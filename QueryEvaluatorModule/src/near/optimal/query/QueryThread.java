package near.optimal.query;

import java.util.ArrayList;
import java.util.HashMap;
import config.StaticData;
import lucenecheck.LuceneSearcher;
import text.normalizer.TextNormalizer;
import utility.MiscUtility;
import utility.QueryLoader;

public class QueryThread implements Runnable {

	String repoName;
	public int bugID;
	String searchQuery;
	final int MAX_GENERATION = StaticData.MAX_GENERATION_COUNT;
	int MAX_QUERY_TERM = StaticData.MAX_QTERM_SUGGESTION;
	String solutionQuery;
	int bestRank;
	String ffName;

	public QueryThread(String repoName, int bugID, String searchQuery, String ffName) {
		this.repoName = repoName;
		this.bugID = bugID;
		this.searchQuery = new TextNormalizer(searchQuery).normalizeBaseline();
		this.ffName=ffName;
	}

	boolean proceedWithLoop(Population2 pop) {
		boolean proceed = false;
		switch (Individual2.ffName) {
		case "QE":
			proceed = (pop.getFittest().getFitness() > FitnessCalc2.getMaxFitness());
			break;

		case "MAP":
			proceed = (pop.getFittest().getFitness() < FitnessCalc2.getMaxFitness());
			break;

		default:
			break;
		}
		return proceed;
	}

	@Override
	public void run() {
		ArrayList<String> terms = new ArrayList<String>(MiscUtility.str2Set(searchQuery));
		Population2 pop = new Population2(StaticData.POPULATION_SIZE, true, repoName, bugID, terms, this.ffName);
		// initialize the algorithm
		Algorithm2 algorithm2 = new Algorithm2(repoName, bugID, terms, ffName);
		int generationCount = 0;

		while (proceedWithLoop(pop)) {
			generationCount++;
			pop = algorithm2.evolvePopulation(pop);
			if (generationCount == StaticData.MAX_GENERATION_COUNT) {
				break;
			}
		}

		Individual2 fittest = pop.getFittest();
		this.solutionQuery = MiscUtility.list2Str(fittest.keywords);
		System.out.println(this.solutionQuery);
		this.bestRank = FitnessCalc2.getFitnessQE(repoName, fittest.bugID, this.solutionQuery);
		System.out.println(bestRank);
		System.out.println("Generation count:"+generationCount);
	}

	public String getSolution() {
		return this.solutionQuery;
	}

	public int getBestRank() {
		return this.bestRank;
	}

	public static void main(String[] args) {
		String repoName = "eclipse.jdt.debug";
		HashMap<Integer, String> queryMap = new HashMap<>();
		String queryFile = StaticData.GA_EXP + "/Baseline/Query/Baseline/" + repoName + ".txt";
		queryMap = QueryLoader.loadQuery(queryFile);

		// StaticData.INDIVIDUAL_GENE_SIZE=queryMap.size();

		int bugID = 189012;
		String ffName="QE";
		LuceneSearcher.TOPK_RESULTS=10;
		String searchQuery = queryMap.get(bugID);
		System.out.println(searchQuery);
		long start = System.currentTimeMillis();
		new QueryThread(repoName, bugID, searchQuery, ffName).run();
		long end = System.currentTimeMillis();
		System.out.println("Elapsed:" + (end - start) / 1000 + "s");
	}
}

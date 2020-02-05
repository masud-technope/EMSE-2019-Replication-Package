package strict.query;

import java.util.ArrayList;
import java.util.HashMap;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import lucenecheck.ClassResultRankMgr;
import query.QTextCollector;
import query.QueryToken;
import config.StaticData;
import core.PageRankProvider;
import core.SearchTermProvider;
import graph.POSNetworkMaker;
import graph.WordNetworkMaker;

import utility.ContentWriter;
import utility.QueryLoader;
import utility.SelectedBugs;

public class STRICTKeywordSelection {

	String repoName;
	ArrayList<Integer> selectedBugs;
	HashMap<Integer, String> titleMap;
	HashMap<Integer, String> descriptionMap;
	static int expansionSize = 10;
	String outputKey;

	static boolean useNL = false;
	static boolean usePEST = false;
	static boolean useALL = false;

	public STRICTKeywordSelection(String repoName, String outputKey) {
		this.repoName = repoName;
		this.outputKey = outputKey;
		this.selectedBugs = populateSelectedBugs();
		this.titleMap = QueryLoader.loadBRTitles(repoName, selectedBugs);
		this.descriptionMap = QueryLoader.loadBRDesc(repoName, selectedBugs);
	}

	protected ArrayList<Integer> populateSelectedBugs() {
		ArrayList<Integer> tempBugs = new ArrayList<Integer>();
		if (useALL) {
			tempBugs = SelectedBugs.getAll3Bugs(repoName);
		}
		return tempBugs;
	}

	protected HashMap<String, Double> initializeTokensDB(DirectedGraph<String, DefaultEdge> myGraph) {
		HashMap<String, Double> tokendb = new HashMap<>();
		for (String node : myGraph.vertexSet()) {
			tokendb.put(node, 0.0);
		}
		return tokendb;
	}

	public HashMap<String, Double> collectSTRICTScores(String scoreKey, String title, String description) {
		ArrayList<String> sentences = getAllSentences(title, description);
		HashMap<String, Double> rankMap = new HashMap<String, Double>();
		switch (scoreKey) {
		case "TR":
			WordNetworkMaker wnMaker = new WordNetworkMaker(sentences);
			DirectedGraph<String, DefaultEdge> textGraph = wnMaker.createWordNetwork();
			HashMap<String, Double> tokendb1 = initializeTokensDB(textGraph);
			PageRankProvider prProvider1 = new PageRankProvider(textGraph, tokendb1);
			rankMap = prProvider1.calculatePageRank();
			break;

		case "POSR":
			POSNetworkMaker pnMaker = new POSNetworkMaker(sentences);
			DirectedGraph<String, DefaultEdge> posGraph = pnMaker.createPOSNetwork();
			HashMap<String, Double> tokendb2 = initializeTokensDB(posGraph);
			PageRankProvider prProvider2 = new PageRankProvider(posGraph, tokendb2);
			rankMap = prProvider2.calculatePageRank();
			break;

		default:
			break;
		}
		return rankMap;
	}

	protected ArrayList<String> getAllSentences(String title, String description) {
		QTextCollector textcollector = new QTextCollector(title, description);
		return textcollector.collectQuerySentencesV3();
	}

	protected void collectSTRICTQueries() {
		ArrayList<String> strictQueries = new ArrayList<>();
		ArrayList<String> stRanks = new ArrayList<>();

		for (int bugID : this.selectedBugs) {
			String title = this.titleMap.get(bugID);
			String description = this.descriptionMap.get(bugID);

			SearchTermProvider stProvider = new SearchTermProvider(title, title + "\n" + description, expansionSize);
			String stQuery = stProvider.provideSearchTerms();
			strictQueries.add(bugID + "\t" + stQuery);
			System.out.println(bugID + "\t" + stQuery);

		}

		//String queryFile = StaticData.GA_EXP + "/ga-query/" + repoName + "/" + outputKey + "-" + expansionSize + ".txt";
		//ContentWriter.writeContent(queryFile, strictQueries);

		// new ResultComparerSingle(repoName, "STRICT").compareResults();

		ClassResultRankMgr.keyMap.clear();
	}

	protected void collectSTRICTScores(String scoreType) {
		for (int bugID : this.selectedBugs) {
			String title = this.titleMap.get(bugID);
			String description = this.descriptionMap.get(bugID);
			HashMap<String, Double> scoreMap = collectSTRICTScores(scoreType, title, title + "\n" + description);
			ArrayList<String> outputLines = new ArrayList<String>();
			for (String key : scoreMap.keySet()) {
				outputLines.add(key + "\t" + scoreMap.get(key));
			}
			String outputFile = StaticData.GA_EXP + "/" + scoreType + "/" + repoName + "/" + bugID + ".txt";
			//ContentWriter.writeContent(outputFile, outputLines);
		}
		System.out.println("Done:" + repoName);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		useALL = true;
		String outputKey = "STRICT-ALL";
		//String scoreKey = "POSR";
		expansionSize = 10;
		String repoName="ecf";

		long start = System.currentTimeMillis();
		//for (String repoName : repos) {
			new STRICTKeywordSelection(repoName, outputKey).collectSTRICTQueries();
			//new STRICTKeywordSelection(repoName, scoreKey).collectSTRICTScores(scoreKey);
			System.out.println("Done:" + repoName);
		//}
		long end = System.currentTimeMillis();
		System.out.println("Time elapsed:" + (end - start) / 1000);
	}
}

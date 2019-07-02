package comparer;

import java.util.ArrayList;
import java.util.HashMap;
import lucenecheck.ClassResultRankMgr;
import lucenecheck.LuceneSearcher;
import utility.ContentLoader;
import utility.SelectedBugs;
import config.StaticData;

public class QueryPerformanceCalc {

	String repoName;
	String queryFile;
	String baselineResultFile;
	String baselineQueryFile;
	ArrayList<Double> RRList;
	ArrayList<Double> APList;
	ArrayList<Integer> selectedBugs;
	static int TOPKQTERMS = 1024;
	HashMap<Integer, Integer> baseRankMap;
	public static double sumAP = 0;
	public static double sumRR = 0;
	public static double sumTopKAcc = 0;
	boolean stem;
	static boolean extractQueryForExt = false;

	public QueryPerformanceCalc(String repoName, String baselineFolder, String queryFileComplete, boolean stem) {
		this.repoName = repoName;
		this.stem = stem;
		this.queryFile = queryFileComplete;
		this.selectedBugs = this.populateSelectedBugs();
		// loading some stuffs
		this.RRList = new ArrayList<>();
		this.APList = new ArrayList<>();
	}

	protected String extractQuery(String line) {
		String[] words = line.split("\\s+");
		String temp = new String();
		for (int i = 1; i < words.length; i++) {
			temp += words[i] + "\t";
			if (i == TOPKQTERMS)
				break;
		}
		return temp.trim();
	}

	protected String extractQueryForExtension(String line) {
		String[] parts = line.split("\t");
		String temp = new String();
		String baselineQuery = parts[2].trim();
		String[] words = parts[1].trim().split("\\s+");
		for (int i = 0; i < words.length; i++) {
			temp += words[i] + "\t";
			if (i + 1 == TOPKQTERMS)
				break;
		}
		return temp.trim() + "\t" + baselineQuery;
	}

	protected double getRR(int firstGoldIndex) {
		if (firstGoldIndex <= 0)
			return 0;
		return 1.0 / firstGoldIndex;
	}

	protected double getRR(ArrayList<Integer> foundIndices) {
		if (foundIndices.isEmpty())
			return 0;
		double min = 10000;
		for (int index : foundIndices) {
			if (index > 0) {
				if (index < min) {
					min = index;
				}
			} else {
				return 0;
			}
		}
		return 1.0 / min;
	}

	protected double getAP(ArrayList<Integer> foundIndices) {
		// calculating the average precision
		int indexcount = 0;
		double sumPrecision = 0;
		if (foundIndices.isEmpty())
			return 0;
		for (int index : foundIndices) {
			indexcount++;
			double precision = (double) indexcount / index;
			sumPrecision += precision;
		}
		return sumPrecision / indexcount;
	}

	protected double getRecall(ArrayList<Integer> foundIndices, ArrayList<String> goldset) {
		// calculating recall
		return (double) foundIndices.size() / goldset.size();
	}

	protected ArrayList<Integer> populateSelectedBugs() {
		return SelectedBugs.getNLSelectedBugs(repoName);
	}

	public double getSTRICTPerformance(int TOPCUT) {
		// getting the strict results
		ArrayList<String> lines = ContentLoader.getAllLinesList(this.queryFile);
		double sumRR = 0;
		double sumAP = 0;
		double TopKAcc = 0;
		// HashSet<Integer> succeeded = new HashSet<>();
		int validcase = 0;
		for (String line : lines) {
			int bugID = Integer.parseInt(line.split("\\s+")[0].trim());
			if (this.selectedBugs.contains(bugID)) {
				String query = extractQuery(line);
				LuceneSearcher searcher = new LuceneSearcher(bugID, repoName, query, stem);

				// setting TOP-K values
				searcher.TOPK_RESULTS = TOPCUT;

				double rr = 0, ap = 0;

				ArrayList<Integer> indices = searcher.getGoldFileIndicesClass();
				if (!indices.isEmpty()) {
					rr = getRR(indices);
					if (rr > 0) {
						sumRR += rr;
					}

					ap = getAP(indices);
					if (ap > 0) {
						sumAP += ap;
						TopKAcc++;
					}
					// succeeded.add(bugID);
					// validcase++;
				}
			}
		}

		// calculating MRR and MAP
		double MRR = sumRR / selectedBugs.size();
		double MAP = sumAP / selectedBugs.size();
		TopKAcc = (double) TopKAcc / selectedBugs.size();

		// System.out.println(MRR+",");

		QueryPerformanceCalc.sumAP += MAP;
		QueryPerformanceCalc.sumRR += MRR;
		sumTopKAcc += TopKAcc;

		// clearing the keys
		ClassResultRankMgr.keyMap.clear();

		return TopKAcc;
	}

	public double getSTRICTPerformanceV2(int topKeywords) {
		ArrayList<String> lines = ContentLoader.getAllLinesList(this.queryFile);
		double sumRR = 0;
		double sumAP = 0;
		double TopKAcc = 0;
		// HashSet<Integer> succeeded = new HashSet<>();
		int validcase = 0;
		for (String line : lines) {
			int bugID = Integer.parseInt(line.split("\\s+")[0].trim());
			if (this.selectedBugs.contains(bugID)) {

				// controlling the no. of keywords
				TOPKQTERMS = topKeywords;

				String query = extractQueryForExt ? extractQueryForExtension(line) : extractQuery(line);

				LuceneSearcher searcher = new LuceneSearcher(bugID, repoName, query, stem);

				// setting TOP-K values
				searcher.TOPK_RESULTS = 10; // checking for top-10 results

				double rr = 0, ap = 0;

				ArrayList<Integer> indices = searcher.getGoldFileIndicesClass();
				if (!indices.isEmpty()) {
					rr = getRR(indices);
					if (rr > 0) {
						sumRR += rr;
					}

					ap = getAP(indices);
					if (ap > 0) {
						sumAP += ap;
						TopKAcc++;
					}
				}
			}
		}

		// calculating MRR and MAP
		double MRR = sumRR / selectedBugs.size();
		double MAP = sumAP / selectedBugs.size();
		TopKAcc = (double) TopKAcc / selectedBugs.size();

		QueryPerformanceCalc.sumAP += MAP;
		QueryPerformanceCalc.sumRR += MRR;
		sumTopKAcc += TopKAcc;

		// clearing the keys
		ClassResultRankMgr.keyMap.clear();

		return TopKAcc;
	}

	public static void main(String[] args) {

		String[] repos = { "ecf", "eclipse.jdt.core", "eclipse.jdt.debug", "eclipse.jdt.ui", "eclipse.pde.ui",
				"tomcat70" };
		
		String methodName = "TF-IDF";
		for (int cut : new int[] { 1, 5, 10 }) {
			for (String repoName : repos) {
				String completeQueryFile = StaticData.GA_EXP + "/" + methodName + "/Query/" + repoName + ".txt";

				String baselineFolder = "baseline-title";

				boolean stem = false;
				// expanding the query
				extractQueryForExt = false;

				double acc = new QueryPerformanceCalc(repoName, baselineFolder, completeQueryFile, stem)
						.getSTRICTPerformance(cut);
			}
			System.out.println(sumTopKAcc / repos.length + ",\t" + QueryPerformanceCalc.sumRR / repos.length + ",\t"
					+ QueryPerformanceCalc.sumAP / repos.length);

			// clearing the values
			QueryPerformanceCalc.sumTopKAcc = 0;
			QueryPerformanceCalc.sumRR = 0;
			QueryPerformanceCalc.sumAP = 0;
		}
	}
}

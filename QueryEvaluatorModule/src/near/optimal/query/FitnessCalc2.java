package near.optimal.query;

import java.util.ArrayList;
import java.util.HashMap;
import lucenecheck.LuceneSearcher;
import utility.MiscUtility;

public class FitnessCalc2 {
	static ArrayList<String> solution = new ArrayList<>();

	// initialize them from outside
	public static HashMap<Integer, String> queryMap;
	public static String repoName;
	public static int fcused = 0;

	public static void setSolution(ArrayList<String> newSolution) {
		solution = newSolution;
	}

	static void setSolution(String newSolution) {
		String[] keywords = newSolution.split("\\s+");
		solution = new ArrayList<String>(keywords.length);
		for (int i = 0; i < keywords.length; i++) {
			String keyword = keywords[i];
			solution.set(i, keyword);
		}
	}

	public static int getFitness(Individual2 individual) {
		int fitness = 0;
		String searchQuery = MiscUtility.list2Str(individual.keywords);
		LuceneSearcher searcher = new LuceneSearcher(individual.bugID, individual.repoName, searchQuery);
		fitness = searcher.getFirstGoldRankClass();
		return fitness;
	}

	public static double getFitnessMAP(Individual2 individual) {
		double fitness = 0;
		String searchQuery = MiscUtility.list2Str(individual.keywords);
		LuceneSearcher searcher = new LuceneSearcher(individual.bugID, individual.repoName, searchQuery);
		fitness = searcher.getAveragePrecisionatK();
		return fitness;
	}

	public static int getFitnessQE(String repoName, int bugID, String searchQuery) {
		int fitness = 0;
		LuceneSearcher searcher = new LuceneSearcher(bugID, repoName, searchQuery);
		fitness = searcher.getFirstGoldRankClass();
		return fitness;
	}

	// Get optimum fitness
	public static int getMaxFitness() {
		// the highest rank that can be achieved
		return 1;
	}

	static int getMinFitness() {
		return 0;
	}
}

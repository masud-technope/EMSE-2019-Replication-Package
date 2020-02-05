package rocchio.maker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import coderank.query.expansion.CandidateTermCollector;
import utility.ItemSorter;
import lucenecheck.TFIDFManager;
import config.StaticData;

public class RocchioRankProvider {

	int bugID;
	String repository;
	String searchQuery;
	final int MAX_SUGGESTION = 10;
	HashSet<String> uniqueTerms;
	String indexFolder;
	public static HashMap<String, Double> idf = new HashMap<>();
	HashMap<String, HashMap<String, Integer>> fileTermMap;
	HashMap<String, Double> rocchioScoreMap;
	CandidateTermCollector ctCollector;
	boolean stem=false;

	public RocchioRankProvider(int bugID, String repoName, String searchQuery,
			boolean stem) {
		this.bugID = bugID;
		this.repository = repoName;
		this.stem = stem;
		this.searchQuery = searchQuery;
		this.uniqueTerms = new HashSet<>();
		this.indexFolder = StaticData.GA_EXP + "/lucene/index-class"
				+ (this.stem ? "-stem" : "") + "/" + repository;
		this.fileTermMap = new HashMap<>();
		this.rocchioScoreMap = new HashMap<>();
	}

	public RocchioRankProvider(int bugID, String repoName, String searchQuery,
			CandidateTermCollector ctCollector) {
		this.bugID = bugID;
		this.repository = repoName;
		this.searchQuery = searchQuery;
		this.uniqueTerms = new HashSet<>();
		this.indexFolder = StaticData.GA_EXP + "/lucene/index-class" + "/" + repository;
		this.fileTermMap = new HashMap<>();
		this.rocchioScoreMap = new HashMap<>();
		this.ctCollector = ctCollector;
	}

	protected void getCandidateTermStats() {
		// performing candidate term statistics
		this.uniqueTerms = ctCollector.getDistinctTerms();
		// System.out.println("Terms from Top-K documents:"+
		// this.uniqueTerms.size());
		this.fileTermMap = ctCollector.getFileTermMap();
		// now collect statistics from the corpus
		if (idf.isEmpty()) {
			TFIDFManager tfIDF=new TFIDFManager(repository, stem);
			idf = tfIDF.calculateIDFOnly();
		}
	}

	protected void calculateTFIDFScores() {
		// calculating the TF-IDF scores
		for (String url : fileTermMap.keySet()) {
			HashMap<String, Integer> wordcount = this.fileTermMap.get(url);
			for (String word : wordcount.keySet()) {
				int tf = wordcount.get(word);
				double idfScore = 0;
				if (this.idf.containsKey(word)) {
					idfScore = this.idf.get(word);
				}
				double tfidf = tf * idfScore;
				if (this.rocchioScoreMap.containsKey(word)) {
					double score = this.rocchioScoreMap.get(word) + tfidf;
					this.rocchioScoreMap.put(word, score);
				} else {
					this.rocchioScoreMap.put(word, tfidf);
				}
			}
		}
	}

	public ArrayList<String> provideRocchioRank() {
		// providing Rocchio ranks for reformulation
		this.getCandidateTermStats();
		this.calculateTFIDFScores();
		List<Map.Entry<String, Double>> sorted = ItemSorter
				.sortHashMapDouble(this.rocchioScoreMap);
		ArrayList<String> ranked = new ArrayList<>();
		for (Map.Entry<String, Double> entry : sorted) {
			// System.out.println(entry.getKey() + "\t" + entry.getValue());
			ranked.add(entry.getKey());
			// if (ranked.size() == MAX_SUGGESTION)
			// break;
		}
		return ranked;
	}

	public HashMap<String, Double> provideRocchioScores() {
		// extract Rocchio scores
		this.getCandidateTermStats();
		this.calculateTFIDFScores();
		// this.normalizeScores();
		this.rocchioScoreMap = this.normalizeByOrder(this.rocchioScoreMap);
		return this.rocchioScoreMap;
	}

	protected void normalizeScores() {
		double maxScore = 0;
		for (String key : this.rocchioScoreMap.keySet()) {
			double keyScore = this.rocchioScoreMap.get(key);
			if (keyScore > maxScore) {
				maxScore = keyScore;
			}
		}
		for (String key : this.rocchioScoreMap.keySet()) {
			double keyScore = this.rocchioScoreMap.get(key);
			keyScore = keyScore / maxScore;
			this.rocchioScoreMap.put(key, keyScore);
		}
	}

	protected HashMap<String, Double> normalizeByOrder(
			HashMap<String, Double> scoreMap) {
		// now normalize the scores
		List<Map.Entry<String, Double>> sorted = ItemSorter
				.sortHashMapDouble(scoreMap);
		int elemCount = sorted.size();
		int index = 0;
		for (Map.Entry<String, Double> entry : sorted) {
			double nscore = 1 - (double) index / elemCount;
			scoreMap.put(entry.getKey(), nscore);
		}
		return scoreMap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bugID = 192756;
		String repository = "ecf";
		String searchQuery = "Bug IRC channel join rid entered spam join big channel ton xxx entered channel entry don messages messages server tab irc freenode net IRC clients";
		boolean stem=false;
		RocchioRankProvider provider = new RocchioRankProvider(bugID,
				repository, searchQuery, stem);
		System.out.println(provider.provideRocchioRank());
	}
}

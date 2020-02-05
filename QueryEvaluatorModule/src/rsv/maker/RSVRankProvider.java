package rsv.maker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import lucenecheck.TFIDFManager;
import utility.ItemSorter;
import config.StaticData;
import coderank.query.expansion.CandidateTermCollector;

public class RSVRankProvider {

	int bugID;
	String repository;
	String searchQuery;
	final int MAX_SUGGESTION = 10;
	HashSet<String> uniqueTerms;
	String indexFolder;
	public static HashMap<String, Double> idf = new HashMap<>();
	public static HashMap<String, Double> tpMap = new HashMap<>();

	HashMap<String, HashMap<String, Integer>> fileTermMap;
	HashMap<String, Double> rsvScoreMap;
	CandidateTermCollector ctCollector;
	boolean stem;

	public RSVRankProvider(int bugID, String repoName, String searchQuery,
			CandidateTermCollector ctCollector, boolean stem) {
		this.bugID = bugID;
		this.repository = repoName;
		this.stem = stem;
		this.searchQuery = searchQuery;
		this.uniqueTerms = new HashSet<>();
		this.indexFolder = StaticData.GA_EXP + "/lucene/index-class/" + repository;
		this.fileTermMap = new HashMap<>();
		this.rsvScoreMap = new HashMap<>();
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
			TFIDFManager tfIDFManager = new TFIDFManager(repository, stem);
			idf = tfIDFManager.calculateIDF();
			// storing other global variables
			tpMap = tfIDFManager.tpMap;
		}
	}

	protected HashMap<String, Double> calculateRSVExtra() {
		// calculating the RSV extra scores
		HashMap<String, Double> tpRMap = new HashMap<>();
		int totalTerminR = 0;
		for (String url : fileTermMap.keySet()) {
			HashMap<String, Integer> wordcount = this.fileTermMap.get(url);
			for (String term : wordcount.keySet()) {
				if (tpRMap.containsKey(term)) {
					double updatedCount = tpRMap.get(term)
							+ wordcount.get(term);
					tpRMap.put(term, updatedCount);
				} else {
					tpRMap.put(term, wordcount.get(term).doubleValue());
				}
				totalTerminR += wordcount.get(term);
			}
		}
		// now get term probabilities for R
		for (String term : tpRMap.keySet()) {
			double probability = tpRMap.get(term) / totalTerminR;
			tpRMap.put(term, probability);
		}

		// now discard the PinC from PinR
		for (String term : tpRMap.keySet()) {
			double pinR = tpRMap.get(term);
			double extra = pinR;
			if (tpMap.containsKey(term)) {
				extra = extra - tpMap.get(term);
			}
			// now update the map
			tpRMap.put(term, extra);
		}
		return tpRMap;
	}

	protected void calculateRSVScores() {

		// calculate the probability in R and C
		HashMap<String, Double> termProbabilityMap = calculateRSVExtra();

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

				// adding the extra score for RSV
				if (termProbabilityMap.containsKey(word)) {
					tfidf = tfidf * termProbabilityMap.get(word);
				}

				if (this.rsvScoreMap.containsKey(word)) {
					double score = this.rsvScoreMap.get(word) + tfidf;
					this.rsvScoreMap.put(word, score);
				} else {
					this.rsvScoreMap.put(word, tfidf);
				}
			}
		}
	}

	public ArrayList<String> provideRSVRank() {
		// providing Rocchio ranks for reformulation
		this.getCandidateTermStats();
		this.calculateRSVScores();
		List<Map.Entry<String, Double>> sorted = ItemSorter
				.sortHashMapDouble(this.rsvScoreMap);
		ArrayList<String> ranked = new ArrayList<>();
		for (Map.Entry<String, Double> entry : sorted) {
			// System.out.println(entry.getKey() + "\t" + entry.getValue());
			ranked.add(entry.getKey());
			// if (ranked.size() == MAX_SUGGESTION)
			// break;
		}
		return ranked;
	}

	public HashMap<String, Double> provideRSVScores() {
		// extract Rocchio scores
		this.getCandidateTermStats();
		this.calculateRSVScores();
		// this.normalizeScores();
		this.rsvScoreMap = this.normalizeByOrder(this.rsvScoreMap);
		return this.rsvScoreMap;
	}

	protected void normalizeScores() {
		double maxScore = 0;
		for (String key : this.rsvScoreMap.keySet()) {
			double keyScore = this.rsvScoreMap.get(key);
			if (keyScore > maxScore) {
				maxScore = keyScore;
			}
		}
		for (String key : this.rsvScoreMap.keySet()) {
			double keyScore = this.rsvScoreMap.get(key);
			keyScore = keyScore / maxScore;
			this.rsvScoreMap.put(key, keyScore);
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

}

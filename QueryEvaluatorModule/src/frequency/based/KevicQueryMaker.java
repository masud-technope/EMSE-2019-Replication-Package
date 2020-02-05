package frequency.based;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lucenecheck.ClassResultRankMgr;
import lucenecheck.LuceneSearcher;
import lucenecheck.TFIDFManager;
import org.apache.commons.lang.StringUtils;
import text.normalizer.TextNormalizer;
import utility.BugReportLoader;
import utility.MiscUtility;
import utility.SelectedBugs;

public class KevicQueryMaker {

	public static HashMap<String, Double> idf;
	static int MAX_TERMS = 5;
	String repoName;
	static boolean APPLY_STEMMING = false;
	String outputKey;

	static boolean useNL = false;
	static boolean usePEST = false;
	static boolean useALL = false;
	
	public KevicQueryMaker(String repoName, String outputKey) {
		// this.bugID = bugID;
		this.repoName = repoName;
		this.outputKey = outputKey;
		idf = new HashMap<>();
		// this.loadBugSource();
		this.loadIDF();
	}

	protected void loadIDF() {
		// loading the TFIDF scores
		if (!idf.isEmpty())
			return;
		TFIDFManager tfidfProvider = new TFIDFManager(repoName, false);
		idf = tfidfProvider.calculateIDFOnly();
	}

	protected HashMap<String, Double> calculateTFIDF(String content) {
		// calculating TFIDF
		HashMap<String, Integer> tf = MiscUtility.wordcount(content.toLowerCase());
		HashMap<String, Double> tfidf = new HashMap<>();
		for (String term : tf.keySet()) {
			double tfidfScore = 0;
			int tfScore = tf.get(term);
			double logTF = (1 + Math.log(tfScore));
			if (idf.containsKey(term)) {
				tfidfScore = logTF * idf.get(term);
			}
			tfidf.put(term, tfidfScore);
		}

		// now normalize the TFIDF scores
		double maxTFIDF = 0;
		for (String key : tfidf.keySet()) {
			double weight = tfidf.get(key);
			if (weight > maxTFIDF) {
				maxTFIDF = weight;
			}
		}
		for (String key : tfidf.keySet()) {
			double weight = tfidf.get(key);
			double normalized = weight / maxTFIDF;
			tfidf.put(key, normalized);
		}
		return tfidf;
	}

	protected HashMap<String, Double> calculateTF(String content) {
		HashMap<String, Integer> tf = MiscUtility.wordcount(content.toLowerCase());
		HashMap<String, Double> tfMap = new HashMap<>();
		for (String word : tf.keySet()) {
			int termFreq = tf.get(word);
			double logtf = 1 + Math.log(termFreq);
			tfMap.put(word, logtf);
		}
		return tfMap;
	}

	protected HashMap<String, Double> calculateIDF(String content) {
		HashMap<String, Integer> tf = MiscUtility.wordcount(content.toLowerCase());
		HashMap<String, Double> IDFMap = new HashMap<>();
		for (String word : tf.keySet()) {
			double idfScore = 0;
			if (idf.containsKey(word)) {
				idfScore = idf.get(word);
				IDFMap.put(word, idfScore);
			}
		}
		return IDFMap;
	}

	protected String getKevicQuery(int bugID) {
		String reportContent = BugReportLoader.loadBugReport(repoName, bugID);
		String[] lines = reportContent.split("\n");
		String title = lines[0];
		String desc = new String();
		for (int i = 1; i < lines.length; i++) {
			desc += lines[i] + "\n";
		}

		String refined = new TextNormalizer().normalizeSimpleCodeDiscardSmall(reportContent);
		// now calculate the TFIDF
		HashMap<String, Double> tfidf = this.calculateTFIDF(refined);
		HashMap<String, Double> termWeight = new HashMap<>();

		String[] words = reportContent.split("\\p{Punct}+|\\s+");
		for (String word : words) {
			double termScore = -2.100;
			// checking different dimensions
			try {
				if (title.contains(word) && desc.contains(word)) {
					termScore += 1.217;
				}
				if ((!title.startsWith(word) && !title.endsWith(word))
						|| (!desc.startsWith(word) && !desc.endsWith(word))) {
					termScore += -.568;
				}
				String[] segments = StringUtils.splitByCharacterTypeCamelCase(word);
				if (segments.length > 1) {
					termScore += 0.907;
				}
				String trimmed = word; // stemmer.stripAffixes(word);
				if (trimmed.length() < 3)
					continue;
				if (tfidf.containsKey(word)) {
					termScore += 3.332 * tfidf.get(word);
				} else if (tfidf.containsKey(trimmed)) {
					termScore += 3.332 * tfidf.get(trimmed);
				}
				termWeight.put(trimmed, termScore);
			} catch (Exception ex) {
				// handle the exception
			}
		}
		return collectTopTerms(termWeight);
	}

	protected String getTFIDFQuery(int bugID) {
		String reportContent = BugReportLoader.loadBugReport(repoName, bugID);
		String refined = new TextNormalizer().normalizeSimpleCodeDiscardSmall(reportContent);
		// now calculate the TFIDF
		HashMap<String, Double> tfidf = this.calculateTFIDF(refined);
		ArrayList<String> allKeys = new ArrayList<>(tfidf.keySet());
		for (String key : allKeys) {
			if (key.length() < 3) { // too small keywords
				// discard small keywords
				tfidf.remove(key);
			}
		}
		return collectTopTerms(tfidf);
	}

	protected String getTFQuery(int bugID) {
		String reportContent = BugReportLoader.loadBugReport(repoName, bugID);
		String refined = new TextNormalizer().normalizeSimpleCodeDiscardSmall(reportContent);
		// now calculate the TFIDF
		HashMap<String, Double> tfidf = this.calculateTF(refined);
		ArrayList<String> allKeys = new ArrayList<>(tfidf.keySet());
		for (String key : allKeys) {
			if (key.length() < 3) { // too small keywords
				// discard small keywords
				tfidf.remove(key);
			}
		}
		return collectTopTerms(tfidf);
	}

	protected String getTFQueryExtended(int bugID) {
		String reportContent = BugReportLoader.loadBugReport(repoName, bugID);
		String title = BugReportLoader.loadBRTitle(repoName, bugID);
		String body = BugReportLoader.loadBRBody(repoName, bugID);


		String refined = new TextNormalizer().normalizeSimpleCodeDiscardSmall(reportContent);
		String refinedTitle = new TextNormalizer().normalizeSimpleCodeDiscardSmall(title);
		ArrayList<String> titleWords = MiscUtility.str2List(refinedTitle);
		String refinedBody = new TextNormalizer().normalizeSimpleCodeDiscardSmall(body);
		ArrayList<String> bodyWords = MiscUtility.str2List(refinedBody);

		// now calculate the TFIDF
		HashMap<String, Double> tfidf = this.calculateTF(refined);
		ArrayList<String> allKeys = new ArrayList<>(tfidf.keySet());
		for (String key : allKeys) {
			if (key.length() < 3) { // too small keywords
				// discard small keywords
				tfidf.remove(key);
			}
		}
		
		// adding bodyKeywordRatio
		allKeys = new ArrayList<>(tfidf.keySet());
		for (String key : allKeys) {
			int flag = -1;
			if (titleWords.contains(key)) {
				if (bodyWords.contains(key)) {
					//both title+body
					flag = 3;
				} else
					//title only
					flag = 1;
			} else if (bodyWords.contains(key)) {
				//body only
				flag = 2;
			}

			if (flag>0 && flag == 1) {
				tfidf.remove(key);
			}
		}

		return collectTopTerms(tfidf);
	}

	protected String getIDFQuery(int bugID) {
		String reportContent = BugReportLoader.loadBugReport(repoName, bugID);
		String refined = new TextNormalizer().normalizeSimpleCodeDiscardSmall(reportContent);
		// now calculate the TFIDF
		HashMap<String, Double> tfidf = this.calculateIDF(refined);
		ArrayList<String> allKeys = new ArrayList<>(tfidf.keySet());
		for (String key : allKeys) {
			if (key.length() < 3) { // too small keywords
				// discard small keywords
				tfidf.remove(key);
			}
		}
		return collectTopTerms(tfidf);
	}

	protected String collectTopTerms(HashMap<String, Double> termWeight) {
		// sorting the tokens
		List<Map.Entry<String, Double>> list = new LinkedList<>(termWeight.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			@Override
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				// TODO Auto-generated method stub
				Double v2 = o2.getValue();
				Double v1 = o1.getValue();
				return v2.compareTo(v1);
			}
		});
		// now collect top three terms
		String query = new String();
		int count = 0;
		for (Map.Entry<String, Double> entry : list) {
			query += entry.getKey() + " ";
			count++;
			if (count == MAX_TERMS)
				break;
		}
		return query;
	}

	protected ArrayList<Integer> populateSelectedBugs() {
		ArrayList<Integer> tempBugs = new ArrayList<Integer>();
		if (useALL) {
			tempBugs = SelectedBugs.getAll3Bugs(repoName);
		}
		return tempBugs;
	}

	protected void makeKevicQuery() {
		// preparing queries for different file
		ArrayList<Integer> selectedBugs = populateSelectedBugs();

		ArrayList<String> results = new ArrayList<>();
		ArrayList<String> ranks = new ArrayList<>();

		for (int bugID : selectedBugs) {
			String kevicQuery = new String();
			switch (outputKey) {
			case "TF":
				kevicQuery = getTFQuery(bugID);
				break;
			case "TF-plus":  //refinement-based on insight
				kevicQuery = getTFQueryExtended(bugID);
				break;
			case "IDF":
				kevicQuery = getIDFQuery(bugID);
				break;
			case "TF-IDF":
				kevicQuery = getTFIDFQuery(bugID);
				break;
			case "org":
				kevicQuery = getKevicQuery(bugID);
				break;
			}
			results.add(bugID + "\t" + kevicQuery);
			// System.out.println(queryLine);
			int QE = getQE(bugID, kevicQuery);
			ranks.add(bugID + "\t" + QE);
		}

		// clearing the map
		ClassResultRankMgr.keyMap.clear();

	}

	protected int getQE(int bugID, String searchQuery) {
		LuceneSearcher searcher = new LuceneSearcher(bugID, repoName, searchQuery);
		return searcher.getFirstGoldRankClass();
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// String repoName = "tomcat70";
		
		MAX_TERMS = 10;
		String outputKey = "TF-plus";
		useALL = true;
		String repoName = "ecf";

		new KevicQueryMaker(repoName, outputKey).makeKevicQuery();
		System.out.println("Done:" + repoName);

		long end = System.currentTimeMillis();
		System.out.println("Time elapsed:" + (end - start) / 1000);
	}
}

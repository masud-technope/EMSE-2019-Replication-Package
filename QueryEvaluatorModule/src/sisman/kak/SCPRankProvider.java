package sisman.kak;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utility.ContentLoader;
import utility.ItemSorter;
import config.StaticData;
import lucenecheck.LuceneSearcher;

public class SCPRankProvider {

	String repoName;
	int bugID;
	String initQuery;
	ArrayList<String> qterms;
	final int W = 10;
	boolean stem;
	String corpusFolder;

	public SCPRankProvider(String repoName, int bugID, String initQuery,
			boolean stem, String corpusFolder) {
		this.repoName = repoName;
		this.corpusFolder=corpusFolder;
		this.stem = stem;
		this.bugID = bugID;
		this.stem = stem;
		this.initQuery = initQuery;
		this.qterms = new ArrayList<String>(Arrays.asList(this.initQuery
				.split("\\s+")));
	}

	protected ArrayList<String> getSCPQuery() {
		// getting SCP queries
		LuceneSearcher searcher0 = new LuceneSearcher(bugID, repoName,
				initQuery, stem);
		ArrayList<String> retResults = searcher0.performVSMSearchList(false);
		HashMap<String, Integer> wordCountMap = new HashMap<>();
		for (String fileURL : retResults) {
			// avoid other files than Java
			if (!fileURL.endsWith(".java"))
				continue;
			String fileName = new File(fileURL).getName();
			int index = Integer.parseInt(fileName.split("\\.")[0]);
			// System.out.println("Index:"+index);

			String srcFile = this.corpusFolder
					+ "/" + index + ".java";

			// we got one line only in the doc
			ArrayList<String> fileTokens = ContentLoader.getAllTokens(srcFile);
			ArrayList<Integer> qIndices = new ArrayList<>();
			for (String token : fileTokens) {
				if (qterms.contains(token)) {
					qIndices.add(index);
				}
				index++;
			}

			// now get the word count using context
			for (int qIndex : qIndices) {
				int startIndex = qIndex - W;
				int endIndex = qIndex + W;
				startIndex = startIndex < 0 ? 0 : startIndex;
				endIndex = endIndex > fileTokens.size() ? fileTokens.size()
						: endIndex;
				// now check the frequency counts
				for (int i = startIndex; i < endIndex; i++) {
					String token = fileTokens.get(i);
					if (wordCountMap.containsKey(token)) {
						int count = wordCountMap.get(token) + 1;
						wordCountMap.put(token, count);
					} else {
						wordCountMap.put(token, 1);
					}
				}
			}
		}
		ArrayList<String> reformulation = new ArrayList<>();
		// now sort the frequent terms
		List<Map.Entry<String, Integer>> sorted = ItemSorter
				.sortHashMapInt(wordCountMap);
		for (Map.Entry<String, Integer> entry : sorted) {
			reformulation.add(entry.getKey());
		}
		return reformulation;
	}
}

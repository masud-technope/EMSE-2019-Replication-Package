package dice.expansion;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import utility.MiscUtility;
import config.StaticData;

public class TFManager {
	String repoName;
	String corpusFolder;
	public HashMap<Integer, HashMap<String, Integer>> docTermMap;
	public HashMap<String, HashSet<Integer>> termDocMap;
	boolean stem;

	public TFManager(String repoName, boolean stem) {
		this.repoName = repoName;
		this.stem = stem;
		this.corpusFolder = StaticData.GA_EXP + "/Corpus/norm-class/" + repoName;
		docTermMap = new HashMap<>();
		termDocMap = new HashMap<>();
	}

	public void getDocTermStatistics() {
		// getting doc term map
		File[] files = new File(this.corpusFolder).listFiles();
		for (File file : files) {
			int fileID = Integer.parseInt(file.getName().split("\\.")[0]);
			HashMap<String, Integer> wordMap = MiscUtility.wordcount(file);
			if (!docTermMap.containsKey(fileID)) {
				docTermMap.put(fileID, wordMap);
			}
			// now get the term doc map
			for (String key : wordMap.keySet()) {
				if (termDocMap.containsKey(key)) {
					HashSet<Integer> temp = termDocMap.get(key);
					temp.add(fileID);
					termDocMap.put(key, temp);
				} else {
					HashSet<Integer> temp = new HashSet<>();
					temp.add(fileID);
					termDocMap.put(key, temp);
				}
			}
		}
		// System.out.println("Docs:"+docTermMap.size());
		// System.out.println("Terms:"+ termDocMap.size());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String repoName = "sling";
		long start = System.currentTimeMillis();
		boolean stem = false;
		new TFManager(repoName, stem).getDocTermStatistics();
		long end = System.currentTimeMillis();
		System.out.println("Time elapsed:" + (end - start) / 1000 + " s");
	}
}

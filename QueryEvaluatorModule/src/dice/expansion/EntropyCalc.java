package dice.expansion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import lucenecheck.TFIDFManager;

public class EntropyCalc {

	HashMap<String, ArrayList<String>> ccExpMap;
	String repoName;
	HashMap<String, Double> entropyMap;
	public HashMap<Integer, HashMap<String, Integer>> docTermMap = new HashMap<>();
	public HashMap<String, HashSet<Integer>> termDocMap = new HashMap<>();
	public HashMap<String, Long> corpusTFMap = new HashMap<>();
	public HashMap<String, Double> corpusTermProbMap = new HashMap<>();
	public HashMap<String, Double> inverseDFMap = new HashMap<>();
	public HashMap<String, Double> documentRatioMap = new HashMap<>();
	public double maxIDF = 0;
	boolean stem;

	public EntropyCalc(HashMap<String, ArrayList<String>> ccExpMap) {
		this.ccExpMap = ccExpMap;
	}

	public EntropyCalc(String repoName, boolean stem) {
		this.repoName = repoName;
		this.entropyMap = new HashMap<>();
		this.stem = stem;
		this.loadItems();
	}

	protected void loadItems() {
		if (docTermMap.isEmpty() || termDocMap.isEmpty()) {
			TFManager tfManager = new TFManager(repoName, stem);
			tfManager.getDocTermStatistics();
			docTermMap = tfManager.docTermMap;
			termDocMap = tfManager.termDocMap;
			// collecting doc ratio
			documentRatioMap = getDocumentRatio();
			this.maxIDF=getMaxIDF();
			//System.out.println("Loaded docs, terms " +repoName);
		}
		if (corpusTFMap.isEmpty()) {
			TFIDFManager tfIDFManager = new TFIDFManager(repoName, stem);
			corpusTFMap = tfIDFManager.calculateTF();
			inverseDFMap = tfIDFManager.calculateIDFOnly();
			corpusTermProbMap = tfIDFManager.calculateTermProb(corpusTFMap);
			this.maxIDF=getMaxIDF();
			//System.out.println("Loaded docs, terms " +repoName);
		}
	}

	public HashMap<String, Double> getEntropies(ArrayList<String> qterms) {
		// calculate term entropies
		int docCount = docTermMap.size();
		// get the entropies for the terms
		for (String key : qterms) {
			double entropy = 0;
			if (termDocMap.containsKey(key)) {
				HashSet<Integer> docs = termDocMap.get(key);
				for (int fileID : docs) {
					int termFrequency = docTermMap.get(fileID).get(key);
					if (corpusTFMap.containsKey(key)) {
						long keyTermFreq = corpusTFMap.get(key);
						double probability = (double) termFrequency
								/ keyTermFreq;
						double logp = Math.log(probability)
								/ Math.log(docCount);
						double ent = probability * logp;
						//using the negation
						ent = ent * -1;
						entropy += ent;
					}
				}
			}
			this.entropyMap.put(key, entropy);
		}
		return this.entropyMap;
	}

	protected HashMap<String, Double> getDocumentRatio() {
		// getting document ratio for terms
		HashMap<String, Double> temp = new HashMap<>();
		int docSize = docTermMap.size();
		for (String key : termDocMap.keySet()) {
			int df = termDocMap.get(key).size();
			double ratio = (double) df / docSize;
			temp.put(key, ratio);
		}
		return temp;
	}

	public HashMap<String, Double> getIDFMap(ArrayList<String> qterms) {
		HashMap<String, Double> idfMap = new HashMap<>();
		for (String term : this.inverseDFMap.keySet()) {
			if (qterms.contains(term)) {
				idfMap.put(term, this.inverseDFMap.get(term));
			}
		}
		return idfMap;
	}

	public double getMaxIDF() {
		int N = docTermMap.size();
		int df = 1;
		return Math.log(0.01 + (double) N / df);
	}

	@Deprecated
	protected HashMap<String, Double> developEntropy() {
		HashSet<String> uniqueKeys = new HashSet<>();
		HashMap<String, Integer> wordCountMap = new HashMap<>();
		HashMap<String, Double> entropyMap = new HashMap<>();
		for (String key : ccExpMap.keySet()) {
			ArrayList<String> values = ccExpMap.get(key);
			uniqueKeys.addAll(values);
		}
		// now develop the entropies
		for (String key : uniqueKeys) {
			for (String ccKey : ccExpMap.keySet()) {
				ArrayList<String> values = ccExpMap.get(ccKey);
				if (values.contains(key)) {
					if (wordCountMap.containsKey(key)) {
						int count = wordCountMap.get(key) + 1;
						wordCountMap.put(key, count);
					} else {
						wordCountMap.put(key, 1);
					}
				}
			}
		}
		// now develop the entropies
		double maxEnt = 0;
		double minEnt = 100;
		for (String key : wordCountMap.keySet()) {
			int count = wordCountMap.get(key);
			double prob = (double) count / uniqueKeys.size();
			double entropy = prob * Math.log(prob);
			if (entropy > maxEnt) {
				maxEnt = entropy;
			}
			if (entropy < minEnt) {
				minEnt = entropy;
			}
			entropyMap.put(key, entropy);
		}

		// now do the normalization
		for (String key : entropyMap.keySet()) {
			double entropy = entropyMap.get(key);
			double normEnt = (entropy - minEnt) / (maxEnt - minEnt);
			entropyMap.put(key, normEnt);
		}
		return entropyMap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> qterms = new ArrayList<>();
		// qterms.add("log");
		// qterms.add("print");
		qterms.add("current");
		qterms.add("count");
		qterms.add("unit");
		qterms.add("name");
		qterms.add("start");
		String repoName = "ecf";
		boolean stem = false;
		System.out
				.println(new EntropyCalc(repoName, stem).getEntropies(qterms));
	}
}

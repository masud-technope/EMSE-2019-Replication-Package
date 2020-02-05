package dice.expansion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import utility.ItemSorter;
import coderank.query.expansion.CandidateTermCollector;

public class DiceRankProvider {

	int bugID;
	String repoName;
	String searchQuery;
	boolean stem;
	CandidateTermCollector ctCollector;
	String[] qterms;
	int MAX_SUGGESTION = 10;
	EntropyCalc entCalc;

	public DiceRankProvider(int bugID, String repoName, String searchQuery,
			CandidateTermCollector ctCollector, EntropyCalc entCalc,
			boolean stem) {
		this.bugID = bugID;
		this.repoName = repoName;
		this.searchQuery = searchQuery;
		this.qterms = this.searchQuery.split("\\s+");
		this.entCalc = entCalc;
		this.stem = stem;
		this.ctCollector = ctCollector;
	}

	protected HashSet<String> getCandidates() {
		return this.ctCollector.candidates;
	}

	protected double getDiceSimilarity(String qterm, String candidate) {

		int qdocsLength = 0;
		int cdocsLength = 0;
		if (!this.entCalc.termDocMap.containsKey(qterm)) {
			return 0;
		}
		if (!this.entCalc.termDocMap.containsKey(candidate)) {
			return 0;
		}
		HashSet<Integer> qdocs = this.entCalc.termDocMap.get(qterm);
		qdocsLength = qdocs.size();
		HashSet<Integer> cdocs = this.entCalc.termDocMap.get(candidate);
		cdocsLength = cdocs.size();
		qdocs.retainAll(cdocs);
		int commonLength = qdocs.size();
		return (double) 2 * commonLength / (qdocsLength * cdocsLength);
	}

	protected ArrayList<String> getDiceRanks() {
		HashSet<String> candidates = getCandidates();
		HashMap<String, Double> diceMap = new HashMap<>();
		for (String candidate : candidates) {
			for (String qterm : qterms) {
				double diceSim = getDiceSimilarity(qterm, candidate);
				if (diceMap.containsKey(candidate)) {
					double newSim = diceMap.get(candidate) + diceSim;
					diceMap.put(candidate, newSim);
				} else {
					diceMap.put(candidate, diceSim);
				}
			}
		}
		// now sort the diceSim
		List<Map.Entry<String, Double>> sorted = ItemSorter
				.sortHashMapDouble(diceMap);
		ArrayList<String> ranked = new ArrayList<>();
		for (Map.Entry<String, Double> entry : sorted) {
			ranked.add(entry.getKey());
		}
		return ranked;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}

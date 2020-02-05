package near.optimal.query;

import java.util.ArrayList;
import java.util.HashMap;
import config.StaticData;

public class Individual2 {

	static int defaultGeneLength = StaticData.INDIVIDUAL_GENE_SIZE;
	int indivSize;
	int length;
	public ArrayList<String> keywords = new ArrayList<>();
	private double fitness = 0;
	HashMap<String, ArrayList<Double>> word2VecMap;
	public int bugID;
	protected String repoName;
	ArrayList<String> allQueryTerms;
	public static String ffName = "QE";

	public Individual2(String repoName, int bugID, ArrayList<String> allQueryTerms) {
		// item initialization in the constructor
		this.allQueryTerms = allQueryTerms;
		this.repoName = repoName;
		this.bugID = bugID;
	}

	public Individual2(String repoName, int bugID, ArrayList<String> allQueryTerms, String ffName) {
		// item initialization in the constructor
		this.allQueryTerms = allQueryTerms;
		this.repoName = repoName;
		this.bugID = bugID;
		Individual2.ffName = ffName;
	}

	public Individual2(String repoName, int bugID, ArrayList<String> allQueryTerms, String ffName,
			HashMap<String, ArrayList<Double>> w2vecMap) {
		// item initialization in the constructor
		this.allQueryTerms = allQueryTerms;
		this.repoName = repoName;
		this.bugID = bugID;
		Individual2.ffName = ffName;
		this.word2VecMap = w2vecMap;
	}

	public void generateIndividual() {
		for (int i = 0;;) {
			if (keywords.size() == defaultGeneLength) {
				break;
			}
			int randomIndex = (int) (keywordCollSize() * Math.random());
			String randomKeyword = allQueryTerms.get(randomIndex);
			keywords.add(randomKeyword);
		}
	}

	public void generateIndividual(int chromosomeLength) {
		for (int i = 0;;) {
			if (keywords.size() == chromosomeLength) {
				break;
			}
			int randomIndex = (int) (keywordCollSize() * Math.random());
			String randomKeyword = allQueryTerms.get(randomIndex);
			keywords.add(randomKeyword);
			i++;
		}
	}

	public static void setDefaultGeneLength(int length) {
		defaultGeneLength = length;
	}

	public String getGene(int index) {

		if (keywords.size() > index) {
			return this.keywords.get(index);
		}
		return " ";
	}

	public void setGene(int index, String keyword) {
		if (keywords.size() > index) {
			if (!keywords.contains(keyword)) {
				keywords.set(index, keyword);
			}
		} else {
			if (!keywords.contains(keyword)) {
				keywords.add(keyword);
			}
		}
		fitness = 0;
	}

	/* Public methods */
	public int size() {
		return defaultGeneLength;
	}

	public int sizeC() {
		return this.length;
	}

	public int keywordCollSize() {
		return this.allQueryTerms.size();
	}

	public double getFitness() {
		if (fitness == 0) {
			switch (ffName) {
			case "QE":
				fitness = FitnessCalc2.getFitness(this);
				break;
			case "MAP":
				fitness=FitnessCalc2.getFitnessMAP(this);
				break;
			}
		}
		return fitness;
	}

	// get collected fitness
	public double getComputedFitness() {
		return this.getFitness();
	}
}

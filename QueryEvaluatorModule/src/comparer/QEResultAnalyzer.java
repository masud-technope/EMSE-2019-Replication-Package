package comparer;

import java.util.ArrayList;
import config.StaticData;

public class QEResultAnalyzer {

	String repoName;
	String methodKey;
	String methodResultFile;
	String baseResultFile;
	static int sumACERrank = 0;
	static int sumBaserRank = 0;
	boolean stem;
	String method;

	static double itemCount = 0;
	static double perc = 0;
	static double mean = 0;
	static double q1 = 0;
	static double q2 = 0;
	static double q3 = 0;
	static double min = 0;
	static double max = 0;

	public QEResultAnalyzer(String approachName) {
		this.method = approachName;
	}

	protected double getMean(ArrayList<Integer> rankList) {
		int vrank = 0;
		double rankSum = 0;
		for (int rank : rankList) {
			if (rank > 0) {
				rankSum += rank;
				vrank++;
			}
		}

		if (vrank == 0)
			return 0;

		return rankSum / vrank;
	}

	protected void getImprovedWorsenedRatios(String[] repos) {

		ArrayList<Double> impRatios = new ArrayList<>();
		ArrayList<Double> worseRatios = new ArrayList<>();

		double sumImprove = 0;
		double sumWorse = 0;
		double sumPreserve = 0;

		int totalImproved = 0;
		int totalWorsened = 0;
		int totalPreserved = 0;

		for (String repoName : repos) {
			System.out.println("Repo:" + repoName);
			String acerResultFile = StaticData.GA_EXP + "/" + this.method + "/QE/" + repoName + ".txt";
			String baseResultFile = StaticData.GA_EXP + "/Baseline/QE/Baseline";
			baseResultFile += "/" + repoName + ".txt";

			ResultComparer rComparer = new ResultComparer(repoName, baseResultFile, acerResultFile, true);
			rComparer.compareResults();
			impRatios.add(rComparer.improvedRatio);
			sumImprove += rComparer.improvedRatio;
			worseRatios.add(rComparer.worsenedRatio);
			sumWorse += rComparer.worsenedRatio;
			sumPreserve += rComparer.preservedRatio;

			System.out.println(
					rComparer.improvedRatio + ",\t" + rComparer.worsenedRatio + ",\t" + rComparer.preservedRatio);

			totalImproved += rComparer.improved;
			totalWorsened += rComparer.worsened;
			totalPreserved += rComparer.preserved;
		}

		// System.out.println(impRatios);
		System.out.println("Improved:" + sumImprove / repos.length);
		// System.err.println(worseRatios);
		System.out.println("Worsened:" + sumWorse / repos.length);
		System.out.println("Preseved:" + sumPreserve / repos.length);

		System.out.println("Dataset size:" + ResultComparer.datasetSize);

		System.out.println(
				"Total improved: " + totalImproved + " " + (double) totalImproved / ResultComparer.datasetSize);

		System.out.println(
				"Total worsened: " + totalWorsened + " " + (double) totalWorsened / ResultComparer.datasetSize);

		System.out.println(
				"Total preserved: " + totalPreserved + " " + (double) totalPreserved / ResultComparer.datasetSize);

	}

	protected double[] convert2Array(ArrayList<Integer> items) {
		double[] ranks = new double[items.size()];
		for (int i = 0; i < ranks.length; i++) {
			ranks[i] = items.get(i);
		}
		return ranks;
	}

	protected double[] getValidRanksOnly(double[] ranks) {
		ArrayList<Double> ranklist = new ArrayList<>();
		for (double rank : ranks) {
			if (rank > 0) {
				ranklist.add(rank);
			}
		}
		double[] vranks = new double[ranklist.size()];
		int index = 0;
		for (double rank : ranklist) {
			vranks[index++] = rank;
		}
		return vranks;
	}

	protected double getValidMean(double[] ranks) {
		double sum = 0;
		int valid = 0;
		for (double rank : ranks) {
			if (rank > 0) {
				sum += rank;
				valid++;
			}
		}
		return sum / valid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] repos = { "ecf", "eclipse.jdt.core", "eclipse.jdt.debug", "eclipse.jdt.ui", "eclipse.pde.ui",
				"tomcat70" };
		String methodName = "ACER";
		QEResultAnalyzer qeResultAnalyzer = new QEResultAnalyzer(methodName);
		qeResultAnalyzer.getImprovedWorsenedRatios(repos);
	}
}

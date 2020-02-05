package near.optimal.query;

import java.util.ArrayList;
import java.util.HashMap;

public class Population2 {

	Individual2[] individuals;

	public Population2(int populationSize, boolean initialize, String repoName, int bugID, ArrayList<String> keywords) {
		individuals = new Individual2[populationSize];
		if (initialize) {
			// Loop and create individuals
			for (int i = 0; i < size(); i++) {
				Individual2 newIndividual = new Individual2(repoName, bugID, keywords);
				newIndividual.generateIndividual();
				saveIndividual(i, newIndividual);
			}
		}
	}

	public Population2(int populationSize, boolean initialize, String repoName, int bugID, ArrayList<String> keywords,
			String ffName) {
		individuals = new Individual2[populationSize];
		if (initialize) {
			// Loop and create individuals
			for (int i = 0; i < size(); i++) {
				Individual2 newIndividual = new Individual2(repoName, bugID, keywords, ffName);
				newIndividual.generateIndividual();
				saveIndividual(i, newIndividual);
			}
		}
	}

	public Population2(int populationSize, boolean initialize, String repoName, int bugID, ArrayList<String> keywords,
			String ffName, HashMap<String, ArrayList<Double>> word2VecMap) {
		individuals = new Individual2[populationSize];
		if (initialize) {
			// Loop and create individuals
			for (int i = 0; i < size(); i++) {
				Individual2 newIndividual = new Individual2(repoName, bugID, keywords, ffName, word2VecMap);
				newIndividual.generateIndividual(keywords.size());
				saveIndividual(i, newIndividual);
			}
		}
	}

	public Individual2 getFittest() {

		Individual2 fittest = individuals[0];
		switch (Individual2.ffName) {
		case "QE":
			fittest = getFittestQE();
			break;
		case "MAP":
			fittest = getFittestMAP();
			break;
		}
		return fittest;
	}

	public Individual2 getFittestQE() {
		Individual2 fittest = individuals[0];
		// Loop through individuals to find the fittest
		double maxFit = 100000;
		for (int i = 0; i < size(); i++) {
			double fitValue = getIndividual(i).getFitness();
			if (fitValue <= maxFit && fitValue > 0) {
				fittest = getIndividual(i);
				maxFit = fitValue;
			}
		}
		return fittest;
	}

	public Individual2 getFittestMAP() {
		Individual2 fittest = individuals[0];
		// Loop through individuals to find the fittest
		double maxFit = 0;
		for (int i = 0; i < size(); i++) {
			double fitValue = getIndividual(i).getFitness();
			if (fitValue > maxFit) {
				fittest = getIndividual(i);
				maxFit = fitValue;
			}
		}
		return fittest;
	}

	public Individual2 getFittestV2() {
		Individual2 fittest = individuals[0];
		double maxFit = fittest.getComputedFitness();
		for (int i = 1; i < size(); i++) {
			double fitValue = getIndividual(i).getFitness();
			if (fitValue > maxFit && (fitValue > 0 && fitValue < 0.5)) {
				fittest = getIndividual(i);
				maxFit = fitValue;
			}
		}
		return fittest;
	}

	public Individual2 getFittestV3() {
		Individual2 fittest = individuals[0];
		double maxFit = fittest.getComputedFitness();
		for (int i = 1; i < size(); i++) {
			double fitValue = getIndividual(i).getFitness();
			if (fitValue > maxFit && fitValue > 0 && fitValue < 1.00) {
				fittest = getIndividual(i);
				maxFit = fitValue;
			}
		}
		return fittest;
	}

	/* Getters */
	public Individual2 getIndividual(int index) {
		return individuals[index];
	}

	public int size() {
		return individuals.length;
	}

	// Save individual
	public void saveIndividual(int index, Individual2 indiv) {
		individuals[index] = indiv;
	}

}

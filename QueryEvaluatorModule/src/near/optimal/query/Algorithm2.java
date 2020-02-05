package near.optimal.query;

import java.util.ArrayList;
import java.util.HashMap;
import config.StaticData;

public class Algorithm2 {
	private static final double uniformRate = StaticData.UNIFORM_CROSSOVER_RATE;
	private static final double mutationRate = StaticData.MUTATION_RATE;
	private static int tournamentSize = StaticData.TOURNAMENT_SIZE;
	private static final boolean elitism = true;

	String currentRepoName;
	int currentBugID;
	ArrayList<String> currentKeywords;
	String ffName = "QE";
	HashMap<String, ArrayList<Double>> word2VecMap;
	ArrayList<Integer> psgFiles;

	public Algorithm2(String currentRepoName, int currentBugID,
			ArrayList<String> currentKeywords) {
		this.currentRepoName = currentRepoName;
		this.currentBugID = currentBugID;
		this.currentKeywords = currentKeywords;
	}

	public Algorithm2(String currentRepoName, int currentBugID,
			ArrayList<String> currentKeywords, String ffName) {
		this.currentRepoName = currentRepoName;
		this.currentBugID = currentBugID;
		this.currentKeywords = currentKeywords;
		this.ffName = ffName;
	}


	public Algorithm2(String currentRepoName, int currentBugID,
			ArrayList<String> currentKeywords, String ffName,
			HashMap<String, ArrayList<Double>> word2VecMap) {
		this.currentRepoName = currentRepoName;
		this.currentBugID = currentBugID;
		this.currentKeywords = currentKeywords;
		this.ffName = ffName;
		this.word2VecMap = word2VecMap;
	}

	public void initializeItems(String repoName, int bugID,
			ArrayList<String> keywords) {
		currentRepoName = repoName;
		currentBugID = bugID;
		currentKeywords = keywords;
	}

	// Select individuals for crossover
	private Individual2 tournamentSelection(Population2 pop) {
		// Create a tournament population
		Population2 tournament = new Population2(tournamentSize, false,
				currentRepoName, currentBugID, currentKeywords, ffName);
		// For each place in the tournament get a random individual
		for (int i = 0; i < tournamentSize; i++) {
			int randomId = (int) (Math.random() * pop.size());
			tournament.saveIndividual(i, pop.getIndividual(randomId));
		}
		// return the fittest
		Individual2 fittest = tournament.getFittest();
		return fittest;
	}

	public Population2 evolvePopulation(Population2 pop) {
		Population2 newPopulation = new Population2(pop.size(), false,
				currentRepoName, currentBugID, currentKeywords, ffName);

		// Keep our best individual
		if (elitism) {
			Individual2 fittest = null;
			fittest = pop.getFittest();
			newPopulation.saveIndividual(0, fittest);
		}
		// Crossover population
		int elitismOffset;
		if (elitism) {
			elitismOffset = 1;
		} else {
			elitismOffset = 0;
		}
		// Loop over the population size and create new individuals with
		// crossover
		for (int i = elitismOffset; i < pop.size(); i++) {
			Individual2 indiv1 = tournamentSelection(pop);
			Individual2 indiv2 = tournamentSelection(pop);
			Individual2 newIndiv = crossover(indiv1, indiv2);
			newPopulation.saveIndividual(i, newIndiv);
		}

		// Mutate population
		for (int i = elitismOffset; i < newPopulation.size(); i++) {
			mutate(newPopulation.getIndividual(i));
		}
		return newPopulation;
	}

	// Crossover individuals
	private Individual2 crossover(Individual2 indiv1, Individual2 indiv2) {
		Individual2 newSol = new Individual2(currentRepoName, currentBugID,
				currentKeywords, ffName);
		// Loop through genes
		for (int i = 0; i < indiv1.size(); i++) {
			// Crossover
			if (Math.random() <= uniformRate) {
				newSol.setGene(i, indiv1.getGene(i));
			} else {
				newSol.setGene(i, indiv2.getGene(i));
			}
		}
		return newSol;
	}

	// Mutate an individual, only changes the alignment of genes
	private void mutate(Individual2 indiv) {
		// Loop through genes
		for (int i = 0; i < indiv.size(); i++) {
			if (Math.random() <= mutationRate) {
				// Create random gene
				int randomIndex = (int) Math.round(Math.random()
						* currentKeywords.size());
				if (randomIndex < currentKeywords.size()) {
					String changedKeyword = currentKeywords.get(randomIndex);
					indiv.setGene(i, changedKeyword);
				}
			}
		}
	}
}

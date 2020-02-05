package dice.expansion;

import java.util.ArrayList;
import lucenecheck.LuceneSearcher;
import coderank.query.expansion.CandidateTermCollector;
import text.normalizer.TextNormalizer;
import utility.ContentLoader;
import utility.MiscUtility;
import utility.SelectedBugs;
import config.StaticData;

public class DiceRQMaker {

	String repoName;
	boolean stem;
	String queryFile;
	String diceQueryFile;
	static ArrayList<String> forbiddenTokens = new ArrayList<>();
	ArrayList<Integer> selectedBugs;
	final int MAX_SUGGESTION = 10;
	EntropyCalc entCalc;
	String corpusFolder;

	public DiceRQMaker(String repoName, boolean stem, String outputKey) {
		this.repoName = repoName;
		this.stem = stem;
		this.queryFile = StaticData.GA_EXP + "/Baseline/Query/" + this.repoName + ".txt";
		this.selectedBugs = SelectedBugs.getAll3Bugs(repoName);
		if (forbiddenTokens.isEmpty()) {
			loadForbiddenTokens();
		}
		this.corpusFolder = StaticData.GA_EXP + "/Corpus/norm-class/" + repoName;
		this.entCalc = new EntropyCalc(repoName, stem);

	}

	protected void loadForbiddenTokens() {
		// loading the forbidden tokens
		ArrayList<String> stops = ContentLoader.getAllLinesOptList("./pp-data/stop-words-english-total.txt");
		ArrayList<String> keywords = ContentLoader.getAllLinesOptList("./pp-data/java-keywords.txt");
		forbiddenTokens.addAll(stops);
		forbiddenTokens.addAll(keywords);
	}

	protected void makeDiceQueries() {
		// preparing Dice queries
		ArrayList<String> queries = new ArrayList<>();
		ArrayList<String> lines = ContentLoader.getAllLinesList(this.queryFile);
		for (String line : lines) {
			String[] tokens = line.split("\\s+");
			int bugID = Integer.parseInt(tokens[0].trim());
			String initQuery = new String();
			for (int i = 1; i < tokens.length; i++) {
				initQuery += tokens[i] + "\t";
			}

			initQuery = initQuery.trim();

			// refine the initial query
			initQuery = new TextNormalizer().normalizeSimpleCodeDiscardSmall(initQuery);

			LuceneSearcher searcher0 = new LuceneSearcher(bugID, repoName, initQuery, this.stem);
			ArrayList<String> retResults = searcher0.performVSMSearchList(false);
			CandidateTermCollector ctCollector = new CandidateTermCollector(repoName, retResults, initQuery,
					this.corpusFolder);
			ctCollector.collectSourceTermStats();

			// now collect the reformulated queries
			DiceRankProvider drankProvider = new DiceRankProvider(bugID, repoName, initQuery, ctCollector, entCalc,
					stem);
			ArrayList<String> diceQueryTokens = drankProvider.getDiceRanks();

			ArrayList<String> refined = discardForbiddenTokens(diceQueryTokens);
			ArrayList<String> reformulation = new ArrayList<>();
			for (String token : refined) {
				reformulation.add(token);
				if (reformulation.size() == MAX_SUGGESTION) {
					break;
				}
			}

			String diceQuery = MiscUtility.list2Str(reformulation);
			System.out.println(diceQuery);

			queries.add(bugID + "\t" + diceQuery + "\t" + initQuery);
		}

		// ContentWriter.writeContent(this.diceQueryFile, queries);

		// now save the retrieved files
		// ContentWriter.writeContent(this.diceQueryFile, queries);
		System.out.println("Dice queries saved successfully: " + repoName);
	}

	protected ArrayList<String> discardForbiddenTokens(ArrayList<String> tokens) {
		// discard forbidden tokens
		ArrayList<String> refined = new ArrayList<>();
		for (String token : tokens) {
			if (!forbiddenTokens.contains(token)) {
				if (token.length() > 2) {
					refined.add(token);
				}
			}
		}
		return refined;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String repoName = "ecf";

		boolean stem = false;
		String outputKey = "Dice-ALL-10";

		new DiceRQMaker(repoName, stem, outputKey).makeDiceQueries();

	}
}

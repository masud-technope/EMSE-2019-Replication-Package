package rocchio.maker;

import java.util.ArrayList;
import coderank.query.expansion.CandidateTermCollector;
import lucenecheck.LuceneSearcher;
import text.normalizer.TextNormalizer;
import utility.ContentLoader;
import utility.ContentWriter;
import utility.MiscUtility;
import utility.SelectedBugs;
import config.StaticData;

public class RocchioRQMakerNew {

	String repoName;
	String queryFile;
	String roccQueryFile;
	ArrayList<Integer> selectedBugs;
	final int MAX_SUGGESTION = 10;
	static ArrayList<String> forbiddenTokens = new ArrayList<>();
	boolean stem;
	String catKey;
	String corpusFolder;

	public RocchioRQMakerNew(String repoName, boolean stem, String outputKey) {
		this.repoName = repoName;
		this.stem = stem;
		this.queryFile = StaticData.GA_EXP + "/Baseline/Query/Baseline" + "/" + this.repoName + ".txt";
		this.roccQueryFile = StaticData.GA_EXP + "/ga-query/" + this.repoName + "/" + outputKey + ".txt";
		this.corpusFolder = StaticData.GA_EXP + "/Corpus/norm-class/" + repoName;
		this.selectedBugs = SelectedBugs.getAll3Bugs(repoName);

		if (forbiddenTokens.isEmpty()) {
			loadForbiddenTokens();
		}
	}

	protected void loadForbiddenTokens() {
		// loading the forbidden tokens
		ArrayList<String> stops = ContentLoader.getAllLinesOptList("./pp-data/stop-words-english-total.txt");
		ArrayList<String> keywords = ContentLoader.getAllLinesOptList("./pp-data/java-keywords.txt");
		forbiddenTokens.addAll(stops);
		forbiddenTokens.addAll(keywords);
	}

	protected void makeRocchioQueries() {
		// preparing Dice queries
		ArrayList<String> queries = new ArrayList<>();
		ArrayList<String> lines = ContentLoader.getAllLinesList(this.queryFile);
		for (String line : lines) {
			String[] tokens = line.split("\\s+");
			int bugID = Integer.parseInt(tokens[0].trim());

			// avoid non-selected bugs
			if (!selectedBugs.contains(bugID))
				continue;

			String initQuery = new String();
			for (int i = 1; i < tokens.length; i++) {
				initQuery += tokens[i] + "\t";
			}
			initQuery = initQuery.trim();

			LuceneSearcher searcher0 = new LuceneSearcher(bugID, repoName, initQuery, stem);
			ArrayList<String> retResults = searcher0.performVSMSearchList(false);
			CandidateTermCollector ctCollector = new CandidateTermCollector(repoName, retResults, initQuery,
					this.corpusFolder);

			ctCollector.collectSourceTermStats();

			// now collect the reformulated queries
			RocchioRankProvider drankProvider = new RocchioRankProvider(bugID, repoName, initQuery, ctCollector);
			ArrayList<String> roccQueryTokens = drankProvider.provideRocchioRank();
			// refine the token list
			ArrayList<String> refined = discardForbiddenTokens(roccQueryTokens);
			ArrayList<String> reformulation = new ArrayList<>();
			for (String token : refined) {
				reformulation.add(token);
				if (reformulation.size() == MAX_SUGGESTION) {
					break;
				}
			}

			initQuery = new TextNormalizer(initQuery).normalizeSimpleCodeDiscardSmall(initQuery);

			String roccQuery = MiscUtility.list2Str(reformulation);
			System.out.println(roccQuery);
			queries.add(bugID + "\t" + roccQuery + "\t" + initQuery);

		}

		//ContentWriter.writeContent(this.roccQueryFile, queries);
		// now save the retrieved files
		// ContentWriter.writeContent(this.diceQueryFile, queries);
		System.out.println("Rocchio queries saved successfully: " + repoName);
	}

	protected ArrayList<String> discardForbiddenTokens(ArrayList<String> tokens) {
		// discard forbidden tokens
		// removing the forbidden tokens
		tokens.removeAll(forbiddenTokens);
		ArrayList<String> refined = new ArrayList<>();
		for (String token : tokens) {
			if (token.length() > 2) {
				refined.add(token);
			}
		}
		return refined;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String repoName="ecf";

		boolean stem = false;
		String catKey = "Rocchio-ALL-10";
		
		new RocchioRQMakerNew(repoName, stem, catKey).makeRocchioQueries();
		
	}
}

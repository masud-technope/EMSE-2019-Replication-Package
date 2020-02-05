package rsv.maker;

import java.util.ArrayList;
import lucenecheck.LuceneSearcher;
import text.normalizer.TextNormalizer;
import utility.ContentLoader;
import utility.ContentWriter;
import utility.MiscUtility;
import utility.SelectedBugs;
import coderank.query.expansion.CandidateTermCollector;
import config.StaticData;

public class RSVRQMaker {

	String repoName;
	String queryFile;
	String rsvQueryFile;
	static ArrayList<String> forbiddenTokens = new ArrayList<>();
	ArrayList<Integer> selectedBugs;
	final int MAX_SUGGESTION = 10;
	boolean stem;
	String corpusFolder;

	public RSVRQMaker(String repoName, boolean stem, String outputKey) {
		this.repoName = repoName;
		this.stem = stem;
		this.queryFile = StaticData.GA_EXP + "/Baseline/Query/Baseline/" + this.repoName + ".txt";
		this.rsvQueryFile = StaticData.GA_EXP + "/ga-query/" + this.repoName + "/" + outputKey + ".txt";
		this.selectedBugs = SelectedBugs.getAll3Bugs(repoName);
		if (forbiddenTokens.isEmpty()) {
			loadForbiddenTokens();
		}
		this.corpusFolder = StaticData.GA_EXP + "/Corpus/norm-class/" + repoName;
	}

	protected void loadForbiddenTokens() {
		// loading the forbidden tokens
		ArrayList<String> stops = ContentLoader.getAllLinesOptList("./pp-data/stop-words-english-total.txt");
		ArrayList<String> keywords = ContentLoader.getAllLinesOptList("./pp-data/java-keywords.txt");
		forbiddenTokens.addAll(stops);
		forbiddenTokens.addAll(keywords);
	}

	protected void makeRSVQueries() {
		// preparing Dice queries
		ArrayList<String> queries = new ArrayList<>();
		ArrayList<String> lines = ContentLoader.getAllLinesList(this.queryFile);
		for (String line : lines) {
			String[] tokens = line.split("\\s+");
			int bugID = Integer.parseInt(tokens[0].trim());
			if (selectedBugs.contains(bugID)) {
				String initQuery = new String();
				for (int i = 1; i < tokens.length; i++) {
					initQuery += tokens[i] + "\t";
				}

				initQuery = initQuery.trim();

				LuceneSearcher searcher0 = new LuceneSearcher(bugID, repoName, initQuery, this.stem);

				// Top-10 feedback will be collected
				searcher0.TOPK_RESULTS = 10;

				ArrayList<String> retResults = searcher0.performVSMSearchList(false);
				CandidateTermCollector ctCollector = new CandidateTermCollector(repoName, retResults, initQuery,
						this.corpusFolder);
				ctCollector.collectSourceTermStats();

				// now collect the reformulated queries
				RSVRankProvider drankProvider = new RSVRankProvider(bugID, repoName, initQuery, ctCollector, this.stem);
				ArrayList<String> rsvQueryTokens = drankProvider.provideRSVRank();
				ArrayList<String> refined = discardForbiddenTokens(rsvQueryTokens);
				ArrayList<String> reformulation = new ArrayList<>();
				for (String token : refined) {
					reformulation.add(token);
					if (reformulation.size() == MAX_SUGGESTION) {
						break;
					}
				}

				String rsvQuery = MiscUtility.list2Str(reformulation);
				
				System.out.println(rsvQuery);

				// refine the initial query properly
				initQuery = new TextNormalizer(initQuery).normalizeSimpleCodeDiscardSmall(initQuery);

				queries.add(bugID + "\t" + rsvQuery + "\t" + initQuery);
			}
		}

		//ContentWriter.writeContent(this.rsvQueryFile, queries);

		// now save the retrieved files
		// ContentWriter.writeContent(this.diceQueryFile, queries);
		System.out.println("RSV queries saved successfully: " + repoName);
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
		String repoName="ecf";
		  
		boolean stem = false;
		String reportGroup = "RSV-ALL-10";
		
		long start = System.currentTimeMillis();

		//for (String repoName : repos) {
			// String repoName = "eclipse.jdt.ui";
		new RSVRQMaker(repoName, stem, reportGroup).makeRSVQueries();
		//}
		long end = System.currentTimeMillis();
		System.out.println("Time needed:" + (end - start) / 1000 + " s");
	}
}

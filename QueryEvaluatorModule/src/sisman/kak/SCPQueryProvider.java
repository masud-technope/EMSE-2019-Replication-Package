package sisman.kak;

import java.util.ArrayList;

import text.normalizer.TextNormalizer;
import utility.ContentLoader;
import utility.ContentWriter;
import utility.MiscUtility;
import utility.SelectedBugs;
import config.StaticData;

public class SCPQueryProvider {

	String repoName;
	String queryFile;
	String scpQueryFile;
	static ArrayList<String> forbiddenTokens = new ArrayList<>();
	ArrayList<Integer> selectedBugs;
	final int MAX_SUGGESTION = 10;
	boolean stem;
	String corpusFolder;

	public SCPQueryProvider(String repoName, boolean stem, String outputKey) {
		this.repoName = repoName;
		this.stem = stem;
		this.queryFile = StaticData.GA_EXP + "/Baseline/Query/Baseline/" + this.repoName + ".txt";
		this.scpQueryFile = StaticData.GA_EXP + "/ga-query/" + this.repoName + "/" + outputKey + ".txt";
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

	protected void makeSCPQueries() {
		// making SCP queries
		ArrayList<String> queries = new ArrayList<>();
		ArrayList<String> lines = ContentLoader.getAllLinesList(this.queryFile);
		for (String line : lines) {
			String[] tokens = line.split("\\s+");
			int bugID = Integer.parseInt(tokens[0].trim());
			if (this.selectedBugs.contains(bugID)) {

				String initQuery = new String();
				for (int i = 1; i < tokens.length; i++) {
					initQuery += tokens[i] + "\t";
				}

				// refine the initial query
				initQuery = new TextNormalizer().normalizeSimpleCodeDiscardSmall(initQuery);

				initQuery = initQuery.trim();
				SCPRankProvider scpRankProvider = new SCPRankProvider(repoName, bugID, initQuery, this.stem,
						this.corpusFolder);
				ArrayList<String> scpTokens = scpRankProvider.getSCPQuery();
				ArrayList<String> refined = discardForbiddenTokens(scpTokens);

				ArrayList<String> reform = new ArrayList<>();
				for (String token : refined) {
					reform.add(token);
					if (reform.size() == MAX_SUGGESTION)
						break;
				}

				String scpQuery = MiscUtility.list2Str(reform);
				System.out.println(scpQuery);
				queries.add(bugID + "\t" + scpQuery + "\t" + initQuery);
			}
		}
		//ContentWriter.writeContent(this.scpQueryFile, queries);
		System.out.println("KAK Queries collected successfully:" + repoName);
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
		
		boolean stem = false;
		String catKey = "SCP-ALL-10";
		
		String repoName="ecf";
		
		//for (String repoName : repos) {
			new SCPQueryProvider(repoName, stem, catKey).makeSCPQueries();
		//}
	}
}

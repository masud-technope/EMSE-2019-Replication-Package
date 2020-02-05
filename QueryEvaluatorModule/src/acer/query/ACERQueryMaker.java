package acer.query;

import java.util.ArrayList;
import java.util.HashMap;
import coderank.query.expansion.CodeRankQueryExpansionProvider;
import lucenecheck.ClassResultRankMgr;
import config.StaticData;
import utility.ContentLoader;
import utility.QueryLoader;
import utility.SelectedBugs;

public class ACERQueryMaker {

	String repoName;
	ArrayList<Integer> selectedBugs;
	String queryFile;
	String indexFolder;
	String srcFolder;
	HashMap<Integer, String> queryTitleMap;
	int expansionSize = 10;
	String itemType;
	String outputKey;
	final int MAX_ALLOWED_KEYWORDS = 1024;

	public ACERQueryMaker(String repoName, String itemType, String outputKey) {
		this.repoName = repoName;
		this.itemType = itemType;
		this.outputKey = outputKey;
		this.selectedBugs = SelectedBugs.getAll3Bugs(repoName);
		this.queryFile = StaticData.GA_EXP + "/Baseline/Query/Baseline/" + repoName + ".txt";
		this.queryTitleMap = QueryLoader.loadBRTitles(repoName, selectedBugs);
		this.indexFolder = StaticData.GA_EXP + "/Lucene/index-class/" + repoName;
		this.srcFolder = StaticData.GA_EXP + "/Corpus/class/" + repoName;
	}

	protected void collectACERQueries() {
		// collect ACER queries
		ArrayList<String> crQueries = new ArrayList<>();
		ArrayList<String> lines = ContentLoader.getAllLinesList(this.queryFile);
		for (String line : lines) {
			String[] tokens = line.split("\\s+");

			int bugID = Integer.parseInt(tokens[0].trim());

			if (selectedBugs.contains(bugID)) {
				String initQuery = new String();
				int baseKwCount = 0;
				for (int i = 1; i < tokens.length; i++) {
					initQuery += tokens[i] + "\t";
					baseKwCount++;
					if (baseKwCount >= MAX_ALLOWED_KEYWORDS)
						break;
				}

				initQuery = initQuery.trim();

				String title = new String();
				if (this.queryTitleMap.containsKey(bugID)) {
					title = this.queryTitleMap.get(bugID);
				}

				CodeRankQueryExpansionProvider cre = new CodeRankQueryExpansionProvider(repoName, bugID, initQuery,
						this.indexFolder, this.srcFolder);
				String crExtension = cre.getCRExtension(expansionSize, true);

				crQueries.add(bugID + "\t" + crExtension + "\t" + initQuery + "\t" + title);
			}
		}

		// String outputFile0 = StaticData.GA_EXP + "/ga-query/" + repoName + "/" +
		// outputKey + ".txt";
		// ContentWriter.writeContent(outputFile0, crQueries);

		ClassResultRankMgr.keyMap.clear();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String repoName="eclipse.pde.ui";
		long start = System.currentTimeMillis();

		String repoName = "ecf";

		String itemType = "mp";
		String outputKey = "ACER-ALL-10-plusT";

		new ACERQueryMaker(repoName, itemType, outputKey).collectACERQueries();
		System.out.println("Done:" + repoName);

		long end = System.currentTimeMillis();
		System.out.println("Time needed:" + (end - start) / 1000 + " s");
	}
}

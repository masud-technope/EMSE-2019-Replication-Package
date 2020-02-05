package near.optimal.query;


import java.util.ArrayList;
import java.util.HashMap;
import lucenecheck.ClassResultRankMgr;
import lucenecheck.LuceneSearcher;
import utility.ContentWriter;
import utility.QueryLoader;
import utility.SelectedBugs;
import config.StaticData;

public class GASearchTermProvider {

	String repoName;
	HashMap<Integer, String> queryMap;
	String queryFile;
	ArrayList<Integer> selectedBugs;
	String resultKey;
	String ffName;

	public GASearchTermProvider(String repoName, String resultKey, String ffName) {
		this.repoName = repoName;
		this.resultKey = resultKey;
		this.queryMap = new HashMap<>();
		this.queryFile = StaticData.GA_EXP + "/Baseline/Query/Baseline/" + repoName + ".txt";
		this.queryMap = QueryLoader.loadQuery(queryFile);
		this.selectedBugs = SelectedBugs.getAll3Bugs(repoName);
		this.ffName = ffName;
	}

	protected void collectBestQueryQEThreaded(int sample) {
		// collecting the best ranks for GA

		ArrayList<Thread> tcoll = new ArrayList<>();
		ArrayList<QueryThread> qtcoll = new ArrayList<>();

		for (int bugID : this.selectedBugs) {
			String searchQuery = this.queryMap.get(bugID);
			QueryThread qt = new QueryThread(repoName, bugID, searchQuery, ffName);
			Thread t = new Thread(qt);
			tcoll.add(t);
			qtcoll.add(qt);
			t.start();
		}

		while (true) {
			int dead = 0;
			for (Thread t : tcoll) {
				if (!t.isAlive()) {
					dead++;
				}
			}
			if (dead == tcoll.size()) {
				break;
			}
		}

		// now collect the results
		ArrayList<String> results = new ArrayList<>();
		ArrayList<String> ranks = new ArrayList<>();
		for (QueryThread qt : qtcoll) {
			String bestQuery = qt.getSolution();
			int QE = qt.getBestRank();
			results.add(qt.bugID + "\t" + bestQuery);
			ranks.add(qt.bugID + "\t" + QE);
			System.out.println(QE +"\t"+bestQuery);
		}

		// saving the queries
		//String outFile = StaticData.GA_EXP + "/ga-query/" + repoName + "/" + resultKey + "-" + sample + ".txt";
		//ContentWriter.writeContent(outFile, results);

		// saving the ranks
		//String outFile2 = StaticData.GA_EXP + "/ga-rank/" + repoName + "/" + resultKey + "-" + sample + ".txt";
		//ContentWriter.writeContent(outFile2, ranks);
	}

	protected int getQE(int bugID, String searchQuery) {
		LuceneSearcher searcher = new LuceneSearcher(bugID, repoName, searchQuery);
		return searcher.getFirstGoldRankClass();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();

		//String[] repos = { "ecf", "eclipse.jdt.core", "eclipse.jdt.debug", "eclipse.jdt.ui", "eclipse.pde.ui",
		//		"tomcat70" };
		
		String[] repos= {"ecf"};

		int sampleTotal = 1;
		String resultKey = "GA-ALL-QE-K10";
		String ffName="QE";
		for (String repoName : repos) {
			GASearchTermProvider stProvider = new GASearchTermProvider(repoName, resultKey, ffName);
			for (int sample = 1; sample <= sampleTotal; sample++) {
				stProvider.collectBestQueryQEThreaded(sample);
				System.out.println("Done: sample " + sample);
			}
			ClassResultRankMgr.keyMap.clear();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Time elapsed:" + (end - start) / 1000 + " s");
	}
}

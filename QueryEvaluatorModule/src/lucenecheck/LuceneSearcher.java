package lucenecheck;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.classic.TokenMgrError;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import config.StaticData;
import utility.ContentLoader;

public class LuceneSearcher {

	int bugID;
	String repository;
	String indexFolder;
	String field = "contents";
	String queries = null;
	int repeat = 0;
	boolean raw = true;
	String queryString = null;
	int hitsPerPage = 10;
	String searchQuery;
	public static int TOPK_RESULTS = 10;
	int ALL_RESULTS = 10000;
	ArrayList<String> results;
	public ArrayList<String> goldset;
	public ArrayList<String> pseudoGoldset;
	public HashMap<String, Double> resultScoreMap;

	IndexReader reader = null;
	IndexSearcher searcher = null;
	Analyzer analyzer = null;

	public double precision = 0;
	public double recall = 0;
	public double precatk = 0;
	public double recrank = 0;

	public static boolean usePseudo = false;

	public LuceneSearcher(int bugID, String repository, String searchQuery) {
		// initialization
		this.bugID = bugID;
		this.repository = repository;
		// checking the class-based index
		this.indexFolder = config.StaticData.GA_EXP + "/Lucene/index-class/" + repository;
		this.searchQuery = searchQuery;
		this.results = new ArrayList<>();
		this.goldset = new ArrayList<>();

		this.resultScoreMap = new HashMap<>();
	}

	public LuceneSearcher(int bugID, String repository, String searchQuery, boolean stem) {
		// initialization
		this.bugID = bugID;
		this.repository = repository;
		// checking the class-based index
		this.indexFolder = config.StaticData.GA_EXP + "/Lucene/index-class" + (stem ? "-stem" : "") + "/" + repository;
		this.searchQuery = searchQuery;
		this.results = new ArrayList<>();
		this.goldset = new ArrayList<>();

		this.resultScoreMap = new HashMap<>();
	}

	public LuceneSearcher(String indexFolder, String searchQuery) {
		this.indexFolder = indexFolder;
		this.searchQuery = searchQuery;
		this.results = new ArrayList<>();
	}

	public ArrayList<String> performVSMSearchList(boolean all) {
		// performing LUECNE search
		boolean validcase = false;
		try {
			if (reader == null)
				reader = DirectoryReader.open(FSDirectory.open(new File(indexFolder).toPath()));
			if (searcher == null)
				searcher = new IndexSearcher(reader);
			if (analyzer == null)
				analyzer = new StandardAnalyzer();
			QueryParser parser = new QueryParser(field, analyzer);

			if (!searchQuery.isEmpty()) {
				Query myquery = parser.parse(searchQuery);
				TopDocs results = searcher.search(myquery, ALL_RESULTS);
				ScoreDoc[] hits = results.scoreDocs;
				if (!all) {
					int len = hits.length < TOPK_RESULTS ? hits.length : TOPK_RESULTS;
					for (int i = 0; i < len; i++) {
						ScoreDoc item = hits[i];
						Document doc = searcher.doc(item.doc);
						String fileURL = doc.get("path");
						fileURL = fileURL.replace('\\', '/');
						this.results.add(fileURL);
						// System.out.print(item.score+", ");
						this.resultScoreMap.put(fileURL, (double) item.score);
					}
				} else {
					for (int i = 0; i < hits.length; i++) {
						ScoreDoc item = hits[i];
						Document doc = searcher.doc(item.doc);
						String fileURL = doc.get("path");
						fileURL = fileURL.replace('\\', '/');
						this.results.add(fileURL);
						this.resultScoreMap.put(fileURL, (double) item.score);
					}
				}
				// checking the gold set
				try {
					if (usePseudo) {
						validcase = getGoldSetNumeric();
					} else {
						validcase = getGoldSet();
					}
				} catch (Exception exc) {
					// handle the exception
				}
			}
		} catch (Exception exc) {
			// exc.printStackTrace();
		} catch (TokenMgrError err) {
			// handle the exception
		}
		return this.results;
	}

	protected boolean getGoldSet() {
		// collecting gold set results
		boolean gsfound = true;
		String goldFile = StaticData.GA_EXP + "/GroundTruth/" + repository + "/" + bugID + ".txt";
		// clear the old values
		if (!this.goldset.isEmpty())
			this.goldset.clear();

		File f = new File(goldFile);
		if (f.exists()) { // if the solution file exists
			String content = ContentLoader.loadFileContent(goldFile);
			String[] items = content.split("\n");
			for (String item : items) {
				if (!item.trim().isEmpty())
					this.goldset.add(item);
			}
		} else {
			gsfound = false;
		}
		return gsfound;
	}

	protected boolean getGoldSetNumeric() {
		// collecting gold set results
		boolean gsfound = true;
		String goldFile = StaticData.GA_EXP + "/GroundTruth/" + repository + "/" + bugID + ".txt";

		// clear the old values
		if (!this.goldset.isEmpty())
			this.goldset.clear();

		File f = new File(goldFile);
		if (f.exists()) { // if the solution file exists
			if (usePseudo) {
				this.goldset = ContentLoader.getAllLinesOptList(goldFile);
			}
		} else {
			gsfound = false;
			// System.out.println("Solution not listed");
		}
		return gsfound;
	}

	public ArrayList<Integer> getGoldFileIndicesClass() {
		ArrayList<Integer> foundIndices = new ArrayList<>();
		this.results = performVSMSearchList(false);
		// System.out.println("TopK:" + this.results.size());
		try {
			ClassResultRankMgr rankFinder = new ClassResultRankMgr(repository, results, goldset);
			ArrayList<Integer> indices = rankFinder.getCorrectRanksDotted(TOPK_RESULTS);
			if (!indices.isEmpty()) {
				foundIndices.addAll(indices);
			}
		} catch (Exception exc) {
			// handle the exception
			exc.printStackTrace();
		}
		return foundIndices;
	}

	public int getFirstGoldRankClass() {
		this.results = performVSMSearchList(true);
		int foundIndex = -1;
		try {
			ClassResultRankMgr rankFinder = new ClassResultRankMgr(repository, results, goldset);
			foundIndex = rankFinder.getFirstGoldRank();
		} catch (Exception exc) {
			// handle the exception
		}
		return foundIndex;
	}

	public double getAveragePrecisionatK() {
		double avgPrec = 0;
		this.results = performVSMSearchList(false);
		try {
			ClassResultRankMgr rankFinder = new ClassResultRankMgr(repository, results, goldset);
			avgPrec = rankFinder.getAveragePrecision();
		} catch (Exception exc) {
			// handle the exception
		}
		return avgPrec;
	}

	public double getAveragePrecisionatKPseudo() {
		double avgPrec = 0;
		this.results = performVSMSearchList(false);
		try {
			ArrayList<Integer> resultFileIDs = new ArrayList<>();
			for (String result : results) {
				File f = new File(result);
				int fileID = Integer.parseInt(f.getName().split("\\.")[0]);
				resultFileIDs.add(fileID);
			}
			ArrayList<Integer> goldFileIDs = new ArrayList<>();
			for (String fileID : this.goldset) {
				goldFileIDs.add(Integer.parseInt(fileID));
			}
			// now get the precision
			double sumPrecision = 0;
			int index = 0;
			int matched = 0;
			for (int elem : resultFileIDs) {
				index++;
				if (goldFileIDs.contains(elem)) {
					matched++;
					sumPrecision += (double) matched / index;
				}
			}
			if (sumPrecision == 0)
				return 0;
			avgPrec = sumPrecision / matched;

		} catch (Exception exc) {
			// handle the exception
		}
		return avgPrec;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int bugID = 31110;
		String repository = "eclipse.jdt.debug";
		// String searchQuery = "tab classpath enabled buttons user entry";
		String searchQuery = "Incorrect comment Intent source code Intents Android app comment WifiConnect WifiConnect Google Book Search search contents book String ACTION google zxing client android WIFI CONNECT comment Wifi book search version product operating system Latest SVN fixed Status FixedOwner srowenLabels Priority Medium Priority";
		// String searchQuery="tab classpath enable button user entry";
		LuceneSearcher searcher = new LuceneSearcher(bugID, repository, searchQuery, false);
		System.out.println("First found index:" + searcher.getFirstGoldRankClass());
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000 + "s");
	}
}

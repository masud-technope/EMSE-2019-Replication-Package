package comparer;

import lucenecheck.LuceneSearcher;

public class SingleQEMaker {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String repoName = "eclipse.jdt.debug";
		int bugID = 30028;
		String searchQuery = "Hierarchy definition";
		int qe = new LuceneSearcher(bugID, repoName, searchQuery)
				.getFirstGoldRankClass();
		System.out.println("QE:" + qe);
	}
}

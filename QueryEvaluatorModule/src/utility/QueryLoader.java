package utility;

import java.util.ArrayList;
import java.util.HashMap;
import config.StaticData;
import text.normalizer.TextNormalizer;

public class QueryLoader {

	protected static String extractQuery(String line) {
		String temp = new String();
		String[] parts = line.split("\\s+");
		for (int i = 1; i < parts.length; i++) {
			temp += parts[i] + "\t";
		}
		return temp.trim();
	}

	public static HashMap<Integer, String> loadQuery(String queryFile) {
		ArrayList<String> qlines = ContentLoader.getAllLinesOptList(queryFile);
		HashMap<Integer, String> queryMap = new HashMap<>();
		for (String line : qlines) {
			int bugID = Integer.parseInt(line.split("\\s+")[0]);
			String query = extractQuery(line);
			queryMap.put(bugID, query);
		}
		return queryMap;
	}

	public static HashMap<Integer, String> loadBRTitles(String repoName, ArrayList<Integer> selectedBugs) {
		// loading the bug report titles
		HashMap<Integer, String> titleMap = new HashMap<>();
		for (int bugID : selectedBugs) {
			String requestFile = StaticData.GA_EXP + "/BugReports/ALL/" + repoName + "/" + bugID + ".txt";
			String title = ContentLoader.getAllLinesOptList(requestFile).get(0);
			title = new TextNormalizer().normalizeSimpleCodeDiscardSmall(title);
			titleMap.put(bugID, title);
		}
		return titleMap;
	}
	
	public static HashMap<Integer, String> loadBRDesc(String repoName, ArrayList<Integer> selectedBugs) {
		// loading the bug report titles
		HashMap<Integer, String> descMap = new HashMap<>();
		for (int bugID : selectedBugs) {
			String requestFile = StaticData.GA_EXP + "/BugReports/ALL/" + repoName + "/" + bugID + ".txt";
			String desc = new String();
			ArrayList<String> lines = ContentLoader.getAllLinesOptList(requestFile);
			if (lines.size() > 1) {
				for (int i = 1; i < lines.size(); i++) {
					desc += lines.get(i) + "\n";
				}
			}
			descMap.put(bugID, desc);
		}
		return descMap;
	}

	public static HashMap<Integer, String> loadQE(String QEFile) {
		ArrayList<String> qlines = ContentLoader.getAllLinesOptList(QEFile);
		HashMap<Integer, String> queryMap = new HashMap<>();
		for (String line : qlines) {
			int bugID = Integer.parseInt(line.split("\\s+")[0]);
			String query = extractQuery(line);
			queryMap.put(bugID, query);
		}
		return queryMap;
	}
}

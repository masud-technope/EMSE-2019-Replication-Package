package utility;

import config.StaticData;

import java.util.ArrayList;

public class BugReportLoader {
	public static String loadBugReport(String repoName, int bugID) {
		String brFile = StaticData.GA_EXP + "/BugReports/ALL/" + repoName + "/" + bugID + ".txt";
		return ContentLoader.loadFileContent(brFile);
	}

	public static String loadBRTitle(String repoName, int bugID) {
		String brFile = StaticData.GA_EXP + "/BugReports/ALL/" + repoName + "/" + bugID + ".txt";
		ArrayList<String> lines = ContentLoader.getAllLinesOptList(brFile);
		return lines.get(0);
	}

	public static String loadBRBody(String repoName, int bugID) {
		String brFile = StaticData.GA_EXP + "/BugReports/ALL/" + repoName + "/" + bugID + ".txt";
		ArrayList<String> lines = ContentLoader.getAllLinesOptList(brFile);
		ArrayList<String> tempList = new ArrayList<String>();
		for (int i = 1; i < lines.size(); i++) {
			tempList.add(lines.get(i));
		}
		return MiscUtility.list2Str(tempList);
	}

}

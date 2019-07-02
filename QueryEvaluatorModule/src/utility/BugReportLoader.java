package utility;

import config.StaticData;

import java.util.ArrayList;

public class BugReportLoader {
	public static String loadBugReport(String repoName, int bugID) {
		String brFile = StaticData.GA_EXP + "/BugReports/" + repoName + "/" + bugID + ".txt";
		return ContentLoader.loadFileContent(brFile);
	}

	public static String loadBRTitle(String repoName, int bugID) {
		String brFile = StaticData.GA_EXP + "/BugReports/" + repoName + "/" + bugID + ".txt";
		ArrayList<String> lines = ContentLoader.getAllLinesOptList(brFile);
		return lines.get(0);
	}

}

package utility;

import java.util.ArrayList;
import config.StaticData;

public class SelectedBugs {
	public static ArrayList<Integer> getNLSelectedBugs(String repoName) {
		String bugFile = StaticData.GA_EXP + "/BugID/" + repoName + ".txt";
		return ContentLoader.getAllLinesInt(bugFile);
	}
}

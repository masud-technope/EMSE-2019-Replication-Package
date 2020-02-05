package utility;

import java.util.ArrayList;
import config.StaticData;

public class SelectedBugs {
	public static ArrayList<Integer> getHQNLBugs(String repoName) {
		String hqNLFile = StaticData.GA_EXP + "/BugID/HQ-NH/" + repoName + ".txt";
		return ContentLoader.getAllLinesInt(hqNLFile);
	}

	public static ArrayList<Integer> getHQPESTBugs(String repoName) {
		String hqPESTFile = StaticData.GA_EXP + "/BugID/HQ-WH/" + repoName + ".txt";
		return ContentLoader.getAllLinesInt(hqPESTFile);
	}

	public static ArrayList<Integer> getLQNLBugs(String repoName) {
		String lqNLFile = StaticData.GA_EXP + "/BugID/LQ-NH/" + repoName + ".txt";
		return ContentLoader.getAllLinesInt(lqNLFile);
	}

	public static ArrayList<Integer> getLQPESTBugs(String repoName) {
		String lqPESTFile = StaticData.GA_EXP + "/BugID/LQ-WH/" + repoName + ".txt";
		return ContentLoader.getAllLinesInt(lqPESTFile);
	}

	public static ArrayList<Integer> getAll3Bugs(String repoName) {
		ArrayList<Integer> tempBugs = new ArrayList<Integer>();
		ArrayList<Integer> hqNLBugs = getHQNLBugs(repoName);
		ArrayList<Integer> hqPESTBugs = getHQPESTBugs(repoName);
		ArrayList<Integer> lqNLBugs = getLQNLBugs(repoName);
		ArrayList<Integer> lqPESTBugs = getLQPESTBugs(repoName);

		tempBugs.addAll(hqNLBugs);
		tempBugs.addAll(hqPESTBugs);
		tempBugs.addAll(lqNLBugs);
		tempBugs.addAll(lqPESTBugs);

		return tempBugs;
	}
}

package comparer;

import java.util.ArrayList;
import java.util.HashMap;
import utility.ContentLoader;
import utility.SelectedBugs;

public class ResultComparer {

    String repoName;
    String baselineResultFile;
    String strictResultFile;
    ArrayList<Integer> selectedBugs;
    HashMap<Integer, Integer> baseRankMap;
    HashMap<Integer, Integer> strictRankMap;
    static ArrayList<String> improvedList = new ArrayList<>();

    ArrayList<Integer> improvedRanks;
    ArrayList<Integer> worsenedRanks;
    ArrayList<Integer> persistedRanks;

    public static double sumImproved = 0;
    public static double sumWorsened = 0;
    public static double sumPreserved = 0;

    int improved = 0;
    int worsened = 0;
    int preserved = 0;

    public double improvedRatio = 0;
    public double worsenedRatio = 0;
    public double preservedRatio = 0;
    static int sumMRD = 0;
    public static int datasetSize;
    int MRD = 0;
    static int goodBaseRank = 0;
    static int validBaseRank = 0;
    static int goodSTRICTRank = 0;
    static int validSTRICTRank = 0;

    static boolean useOptimal = false;

    public ResultComparer(String repoName, String baseResultFile,
                          String strictResultFile, boolean includedInSuite) {
        this.repoName = repoName;
        this.baselineResultFile = baseResultFile;
        this.strictResultFile = strictResultFile;

        this.baseRankMap = new HashMap<>();
        this.strictRankMap = new HashMap<>();

        this.improvedRanks = new ArrayList<>();
        this.worsenedRanks = new ArrayList<>();
        this.persistedRanks = new ArrayList<>();

        this.selectedBugs = new ArrayList<>();

        // populating the required results
        if (useOptimal) {
            //this.populateSelectedBugsV3();
        } else {
            this.populateSelectedBugsV2();
        }

        this.populateBaseResultsV2(); // now using V2
        this.populateSTRICTResults();
    }

	protected void populateSelectedBugsV2() {

		this.selectedBugs = SelectedBugs.getAll3Bugs(repoName);
	}
  
    protected void populateBaseResultsV2() {

        String[] lines = ContentLoader.getAllLines(this.baselineResultFile);
        int goodBaseRankSingle = 0;
        int validBaseRankSingle = 0;
        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            int bugID = Integer.parseInt(line.split("\\s+")[0].trim());
            int rank = Integer.parseInt(line.split("\\s+")[1].trim());
            if (this.selectedBugs.contains(bugID)) {
                this.baseRankMap.put(bugID, rank);
                if (rank > 0 && rank <= 10) {
                    goodBaseRank++;
                    goodBaseRankSingle++;
                }
                if (rank > 0) {
                    validBaseRank++;
                }
            }
        }
    }

    protected void populateSTRICTResults() {
        // populating the base results
        String[] lines = ContentLoader.getAllLines(this.strictResultFile);
        int goodRankSingle = 0;
        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            int bugID = Integer.parseInt(line.split("\\s+")[0].trim());
            // int rank = Integer.parseInt(line.split("\\s+")[1].trim());
            int rank = (int) Double.parseDouble(line.split("\\s+")[1].trim());
            if (selectedBugs.contains(bugID)) {
                this.strictRankMap.put(bugID, rank);
                if (rank > 0 && rank <= 10) {
                    goodSTRICTRank++;
                    goodRankSingle++;
                }
                if (rank > 0) {
                    validSTRICTRank++;
                }
            }
        }
    }

    public double compareResults() {
        // comparing our result with baseline

        int strictRankSum = 0;
        int baseRankSum = 0;
        int svcount = 0;
        int bvcount = 0;

        for (int bugID : this.selectedBugs) {

            if (!baseRankMap.containsKey(bugID)) continue;

            int baserank = this.baseRankMap.get(bugID);
            int strictRank = -1;
            if (strictRankMap.containsKey(bugID)) {
                strictRank = this.strictRankMap.get(bugID);
            }
            if (strictRank > 0) {
                strictRankSum += strictRank;
                svcount++;

                if (baserank > 0) {

                    baseRankSum += baserank;
                    bvcount++;

                    if (strictRank < baserank) {
                        improved++;
                        this.improvedList.add(bugID + "");
                        // strictRankSum += strictRank;
                        improvedRanks.add(strictRank);
                    } else if (strictRank == baserank) {
                        preserved++;
                        persistedRanks.add(strictRank);
                    } else if (strictRank > baserank) {
                        worsened++;
                        baseRankSum += baserank;
                        worsenedRanks.add(strictRank);
                    }
                } else {
                    if (strictRank > 0) {
                        improved++;
                        // strictRankSum += strictRank;
                        improvedRanks.add(strictRank);
                        this.improvedList.add(bugID + "");
                    }
                }
            } else {
                if (baserank == strictRank) {
                    preserved++;
                } else {
                    worsened++;
                    baseRankSum += baserank;
                }
            }
        }

        this.improvedRatio = (double) improved / selectedBugs.size();
        sumImproved += this.improvedRatio;
        // System.out.println("Improved:" + improvedRatio);
        this.worsenedRatio = (double) worsened / selectedBugs.size();
        sumWorsened += this.worsenedRatio;
        // System.out.println("Worsened:" + worsenedRatio);
        this.preservedRatio = (double) preserved / selectedBugs.size();
        sumPreserved += this.preservedRatio;
        // System.out.println("Preserved:" + preservedRatio);

        datasetSize += this.selectedBugs.size();
        return this.improvedRatio;
    }

    public static void main(String[] args) {
     
    }
}

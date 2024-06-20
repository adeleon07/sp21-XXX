package gitlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class does at a high level.
 *  Creates the hidden repository and sets up persistence, and generate the initial commit.
 *
 *  @Andre
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");
    public static final File BLOB_DIR = join(GITLET_DIR, "blobs");

    /** Staging area with additional folders to handle adding and removing files from staging */
    public static final File STAGE_DIR = join(GITLET_DIR, "stage");
    public static final File STAGE_ADD_FILE = join(STAGE_DIR, "Map_Stage_Add");
    public static final File STAGE_REMOVE_FILE = join(STAGE_DIR, "Map_Stage_Remove");

    /** Directory for storing commits. */
    public static final File COMMITS_DIR = join(GITLET_DIR, "commits");
    /** Directory for storing different branches. */
    public static final File BRANCHES_DIR = join(GITLET_DIR, "branches");
    public static final File LOGS_DIR = join(GITLET_DIR, "logs");

    /** HashMap to keep track of the files in the staging area */
    //public static Map<String, String> stageAdd = new HashMap<>();
    //public static Map<String, String> stageRmv = new HashMap<>();
    public static Staging stagingArea = new Staging();

    static final String SENTINEL_COMMIT_ID = "6cf73ef132f3f89a94f4c73ec879aa79ba529e86";
    static final String INIT_PARENT_SHA1 = "0000000000000000000000000000000000000000";

    public static void init() throws IOException {

        if (GITLET_DIR.exists()) {
            System.out.println("A Gitlet version-control system already exists " +
                    "" + "in the current directory.");
            System.exit(0);
        }

        //create the gitlet directory
        GITLET_DIR.mkdir();
        BLOB_DIR.mkdir();
        STAGE_DIR.mkdir();
        COMMITS_DIR.mkdir();
        LOGS_DIR.mkdir();
        BRANCHES_DIR.mkdir();

        Map<String, String> sentinelMap = new HashMap<>();
        Commit sentinel = new Commit("sentinel", sentinelMap);
        Commit initialCommit = new Commit("initial commit", sentinel.getSHA(), true, new HashMap<>());
        sentinel.saveInit();
        initialCommit.saveInit();
        // OBSELETE create the initial commit with the message and time and commits it.
        //Commit initialCommit = new Commit();
        //initialCommit.writeCommit();


        /** Set the global head to the initial commit and create a master branch pointing
         to the initial commit.*/
        Head.setBranchHEAD("master", initialCommit);
        Head.setGlobalHEAD("master", initialCommit);

        /**
         * Generates the first instance of the staging area
         * with an empty add and removal area.
         */
        stagingArea.save();
    }

    public static void add(String fileName) throws IOException {

        //Verify the file exists by comparing it to a file object
        File fileToAdd = new File(fileName);
        if (!fileToAdd.exists() || !fileToAdd.isFile()) {
            System.out.print("File does not exist.");
            System.exit(0);
        }

        if (isSameVersionAsLastCommit(fileName)) {
            if (stagingArea.containsFileForRemoval(fileName)) {
                stagingArea.removeFromStagedForRemoval(fileName);
            }

            stagingArea.save();
            return;
        }

        Blob blob = new Blob(fileName);
        blob.save();
        stage(fileName, blob);

    }

        private static void stage(String fileName, Blob blob) {
            stagingArea = stagingArea.load();
            stagingArea.add(fileName, blob.getBlobSHA1());
            stagingArea.save();
        }

        public static boolean isSameVersionAsLastCommit(String currFileName) {
            String CWD = System.getProperty("user.dir");
            File currentFile = new File(CWD, currFileName);

            Commit currCommit = Head.getGlobalHEAD();
            String blobSHA1 = currCommit.getSnapshot().get(currFileName);

            if (blobSHA1 == null) {
                return false;
            }

            File blobOfPrevVersion = Utils.join(BLOB_DIR, blobSHA1);

            return hasSameContent(currentFile, blobOfPrevVersion);
        }

        /**
         * Compares the byte array of the file in CWD and the byte array
         * saved in the last commit/blob.
         * @param 'currVersion' file in CWD
         * @param 'blobOfPrevVersion' the blob of the same file saved in current commit.
         * */
        public static boolean hasSameContent(File currVersion, File blobOfPrevVersion) {
            Blob blob = Blob.load(blobOfPrevVersion);
            byte[] versionInCurrCommit = blob.getFileContent();
            byte[] versionInCWD = Utils.readContents(currVersion);
            return Arrays.equals(versionInCurrCommit, versionInCWD);

        }
}

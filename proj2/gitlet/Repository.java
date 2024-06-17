package gitlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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


    /** HashMap to keep track of the files in the staging area */
    //public static Map<String, String> stageAdd = new HashMap<>();
    //public static Map<String, String> stageRmv = new HashMap<>();
    public static Map<String, String> staging = new HashMap<>();

    /* TODO: fill in the rest of this class. */

    public static void init() {

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
        BRANCHES_DIR.mkdir();

        //create the initial commit with the message and time and commits it.
        Commit initialCommit = new Commit();
        initialCommit.writeCommit();


        /** Set the global head to the initial commit and create a master branch pointing
         to the initial commit.*/
        Head.setBranchHEAD("master", initialCommit);
        Head.setGlobalHEAD("master", initialCommit);

    }

    public static void add(String fileName) throws IOException {

        //Verify the file exists by comparing it to a file object
        File fileToAdd = new File(fileName);
        if (!fileToAdd.exists() || !fileToAdd.isFile()) {
            System.out.print("File does not exist.");
            System.exit(0);
        }
        // TODO - AD, validate number of args?
        // TODO - AD, create a method to save to the stage
        // make sure there is a stage to save to, directory in this case - done
        // stage should be some data structure, here we'll make it a hash map - done (explain why in docs)
        // TODO - AD, create a way to save a blob to staging
        // create a new blob object - done
        // blob needs to be hashed with SHA1 - done with blob obj
        // Save to staging area - partially done
        //      need to implement a save method for staging
        Blob blob = new Blob(fileName);
        blob.save();
        File index = Utils.join(STAGE_DIR, "index");
        Utils.writeObject(index, STAGE_DIR);
        System.out.print("Added " + fileName + " to the staging area");
        }

        // TODO - AD, update head and master branches. maybe do a linked list later?
        //Read contents of file from working directory
        //TODO - AD
        // TEMP COMMENT String contents = Utils.readContentsAsString(fileToAdd);
        // TEMP COMMENT String version = sha1(contents);

        //Loading StageAdd hashmap (why this?) 5/30 commented out
        //stageAdd = readObject(STAGE_ADD_FILE, HashMap.class);
        //stageRmv = readObject(STAGE_REMOVE_FILE, HashMap.class);

        //Compares CWD version to the latest commit version
        // TEMP COMMENT String head = readHeadCommitUID();
       // Commit currentCommit = fromFile(head); 5/30/ commented out

        //Determine if the blob is unique compared to any of the current commit's blobs
       /** TEMP COMMENT
        if (isSameVersionAsLastCommit(fileName)) {
            //remove file
            return;
        }
        */

        //Commit currentCommit = Utils.readObject(CURRENT_COMMIT_FILE)
        /*

        if (head.containsBlob(fileToAdd)) {
            System.exit(0);
        }
        //if yes, add to staging,
        addToStage(fileName);
        */
    // TEMP COMMENT }

    public static void saveStage() {
        for (Map.Entry<String, String> entry : staging.entrySet()) {
            String fileName = entry.getKey();
            String fileHash = entry.getValue();
        }

        // TEMP COMMENT File stagedFile = new File(staging, fileHash);
    }
    public static String readHeadCommitUID(){
        Branch branch = Utils.readObject(HEAD_FILE, Branch.class);
        return branch.getName();
    }
    public static boolean isSameVersionAsLastCommit(String currFileName) {
        //Get file
        //Get Commit
        //
        File currentFile = new File(CWD, currFileName);
        return true;
        //
    }
    private static void addToStage(String fileToAdd) {
        Blob blob = new Blob(fileToAdd);
        String blobId = Utils.sha1(serialize(blob));
        File addPath = join(Repository.STAGE_DIR, blobId);
        //if current working version == file to add remove from staging
    }
}

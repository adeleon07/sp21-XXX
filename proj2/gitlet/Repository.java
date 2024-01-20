package gitlet;

import java.io.File;
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
    public static final File STAGE_DIR = join(GITLET_DIR, "stage");

    public static final File COMMITS_DIR = join(GITLET_DIR, "commits");

    //public static final File REFS_DIR = join(GITLET_DIR, "refs"); // not sure what this is, replaced by commits 1/19/24
    public static final File BRANCHES_DIR = join(GITLET_DIR, "branches"); // not too sure 1/19/24



    /* TODO: fill in the rest of this class. */

    public static void init() {

        if (GITLET_DIR.exists()) {
            System.out.println("A Gitlet version-control system already exists" +
                    "" + "in the current directory.");
            System.exit(0);
        }

        //create the gitlet directory
        GITLET_DIR.mkdir();
        BLOB_DIR.mkdir();
        STAGE_DIR.mkdir();
        COMMITS_DIR.mkdir();
        BRANCHES_DIR.mkdir();

        //create the intial commit with the message and time
        Commit initialCommit = new Commit();

        // TODO - AD: save commit
        //write the commit (should I perform this in the initial commit stage?)
        //Serialize the commit to disk
        //would write contents be part of the serializbe class?
        initialCommit.writeCommit();


        // TODO - AD: create master branch
        Branch branch = new Branch("mater", initialCommit.getUid());
        //write the branch? what does this mean.

    }
}

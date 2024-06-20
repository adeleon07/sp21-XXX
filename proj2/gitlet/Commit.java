package gitlet;

// TODO: any imports you need here

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import java.io.File;
import static gitlet.Utils.*;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /**
     * the SHA1s of a commit node's parent nodes.
     */
    private String[] parents = new String[2];

    /**
     * the SHA1 of a commit node.
     */
    private String sha1;
    /** The message of this Commit. */
    private String message;
    private Date timestamp;

    /**
     *  The snapshot of a commit node, which is stored
     *  as a mapping of the SHA1 of a staged file
     *  and the SHA 1 of a blob
     */
    private Map<String, String> snapshot;

    private HashSet<String> deletedSnaphot = new HashSet<>();

    private boolean init = false;

    /** Initial commit constructor. Distinguished by the inputs*/
    public Commit(String msg, String parent, boolean initial, Map<String, String> map){
        List<String> list = new ArrayList<>(map.values());

        //create unique sha
        String blobFileNames = "";
        for (String blobFileName : list) {
            blobFileNames += blobFileName;
        }

        this.message = msg;
        this.parents[0] = parent;
        this.sha1 = Utils.sha1("COMMIT" + message + blobFileNames);
        this.snapshot = map;
        this.init = initial;
        if (msg == "initial commit") {
            this.timestamp = new Date(0);
        } else {
            this.timestamp = new Date();
        }


    }
    /** Used for init command only.*/
    public Commit(String msg, Map<String, String> map) {
        this.message = msg;
        this.snapshot = map;
        this.parents[0] = Repository.INIT_PARENT_SHA1;
        this.sha1 = Utils.sha1("COMMIT" + message);
        this.timestamp = new Date(0);
    }

    /* TODO: fill in the rest of this class. */

    /**
    public void writeCommit(){
        String id = Utils.sha1(serialize(this)); //to serial or not serialze object
        File commitPath = join(Repository.COMMITS_DIR, id);
        this.uid = id;
        Utils.writeObject(commitPath, this); //this or id?

    }
     */
    public void saveInit() throws IOException {
        Commit commit = new Commit(this.message, this.parents[0], true, this.snapshot);
        File commitFile = Utils.join(Repository.COMMITS_DIR, this.sha1);
        File commitLogs = Utils.join(Repository.LOGS_DIR, this.sha1);
        commitFile.createNewFile();
        commitLogs.createNewFile();
        Utils.writeObject(commitFile, commit);
        Utils.writeObject(commitLogs, commit);
    }

    public String getSHA(){
        return this.sha1;
    }

    /**
     * Return the snapshot hashmap of a commit node.
     */
    public Map<String, String> getSnapshot() {
        return this.snapshot;
    }

    /**
    public boolean containsBlob(File fileName) {
        return commitBlobs.containsKey(fileName);
    }
    */
    public void addBlob (Blob blob) {
        // TODO - AD?
    }

}

package gitlet;

// TODO: any imports you need here

import java.io.Serializable;
import java.util.Date;

import java.io.File;
import static gitlet.Utils.*;

import java.util.HashMap;
import java.util.Map;

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
    private String[] parents;
    private String uid;
    /** The message of this Commit. */
    private String message;
    private Date timestamp;

    private HashMap<String, Blob> commitBlobs;



    /** Initial commit constructor. Distinguished by the inputs*/
    public Commit(){
        this.commitBlobs = new HashMap<String, Blob>();
        this.message = "initial commit";
        this.timestamp = new Date(0);

    }

    /* TODO: fill in the rest of this class. */

    public void writeCommit(){
        String id = Utils.sha1(serialize(this)); //to serial or not serialze object
        File commitPath = join(Repository.COMMITS_DIR, id);
        this.uid = id;
        Utils.writeObject(commitPath, this); //this or id?

    }

    public String getUid(){
        return this.uid;
    }

    public boolean containsBlob(File fileName) {
        return commitBlobs.containsKey(fileName);
    }

    public void addBlob (Blob blob) {
        // TODO - AD?
    }
}

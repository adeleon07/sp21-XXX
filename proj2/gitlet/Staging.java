package gitlet;

import org.apache.commons.collections.bidimap.TreeBidiMap;

import java.io.File;
import java.util.Map;
import java.util.HashSet;
import java.io.Serializable;
import java.util.TreeMap;

public class Staging implements Serializable {
    private Map<String, String> stagedForAddition;
    private HashSet<String> stagedForRemoval;

    public Staging () {
        this.stagedForAddition = new TreeMap<String, String>();
        this.stagedForRemoval = new HashSet<String>();
    }

    public Staging(Map<String, String> trackedFiles, HashSet<String> untrackedFiles) {
        this.stagedForAddition = trackedFiles;
        this.stagedForRemoval = untrackedFiles;
    }

    public void save() {
        Staging stage = new Staging(this.stagedForAddition, this.stagedForRemoval);
        File index = Utils.join(Repository.STAGE_DIR, "index");
        Utils.writeObject(index, stage);
    }
    public Staging load() {
        File index = Utils.join(Repository.STAGE_DIR, "index");
        return Utils.readObject(index, Staging.class);
    }

    public void add(String fileName, String blobSHA1) {
        this.stagedForAddition.put(fileName, blobSHA1);
    }
}

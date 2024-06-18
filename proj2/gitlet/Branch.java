package gitlet;

import java.io.File;
import java.io.Serializable;
public class Branch implements Serializable {
    /** Name of the branch */
    private String branchName;
    /** The last commit node of the current branch */
    private Commit head;


    /** Instantiate a branch
     * @param 'branchName' the name of the saved branch.
     * @param 'commit' the last commit node of the branch.
     */
    public Branch(String name,Commit commit) {
        this.branchName = name;
        this.head = commit;
    }
    public String getName() {
        return this.branchName;
    }

    public static Branch load(File branch) {
        return Utils.readObject(branch, Branch.class);
    }

    public Commit getHEAD() {
        return this.head;
    }
}

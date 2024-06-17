package gitlet;

import java.io.File;

public class Head {

    /**
     * Set up the global HEAD, default to master
     * @param 'branchName' the branchName
     * @param 'commit' the commit
     * */

    public static void setGlobalHEAD(String branchName, Commit commit) {

        Branch branch = new Branch(branchName, commit);
        File branchFile = Utils.join(Repository.GITLET_DIR, "HEAD");
        Utils.writeObject(branchFile, branch);
    }

    public static void setBranchHEAD(String branchName, Commit commit) {

        Branch branch = new Branch(branchName, commit);
        File branchFile = Utils.join(Repository.BRANCHES_DIR, branchName);
        Utils.writeObject(branchFile, branch);
    }
}

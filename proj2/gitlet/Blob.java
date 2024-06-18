package gitlet;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
public class Blob implements Serializable {


    private String fileName;
    private byte[] fileContent;
    private String blobSHA1;


    public Blob(String filename) {
        this.fileName = filename;
        this.fileContent = Utils.readContents(Utils.join(".", filename));
        this.blobSHA1 = Utils.sha1(fileContent);

    }

    public Blob(String fileName, byte[] fileContent, String blobSHA1){
        this.fileName = fileName;
        this.fileContent = fileContent;
        this.blobSHA1 = blobSHA1;
    }

    /** Save a blob as a byte array. Use SHA1 as its file name. */
    public void save() throws IOException {
        Blob blob = new Blob(this.fileName, this.fileContent, this.blobSHA1);
        File blobFile = Utils.join(Repository.BLOB_DIR, this.getBlobSHA1());
        try {
            blobFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Utils.writeObject(blobFile, blob);
    }

    /** Return a blob object from the byte array
     * @param 'blob' the blob
     */
    public static Blob load(File blob) {
        return Utils.readObject(blob, Blob.class);
    }

    public String getBlobSHA1(){
        return this.blobSHA1;
    }

}

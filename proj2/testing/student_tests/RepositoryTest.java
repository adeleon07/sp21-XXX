package testing.student_tests;
import gitlet.Repository;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class RepositoryTest {

    private static final String TEST_DIR = "test_gitlet";
    private static final String GITLET_DIR = "test_gitlet/.gitlet";
    private Repository repository;

    @Before
    public void setup() throws IOException {
        // Create a test directory
        File dir = new File(TEST_DIR);
        if(!dir.exists()) {
            dir.mkdirs();
        }

        // Change working directory to TEST_DIR for duration of test
        System.setProperty("user.dir", TEST_DIR);

        // Initialize the repository instance
        repository = new Repository();
    }

    @After
    public void tearDown() throws IOException {
        // Reset working directory to original
        System.setProperty("user.dir", new File(".").getAbsolutePath());

        // Clean up test directory
        Path directory = Paths.get(TEST_DIR);
        if (Files.exists(directory)) {
            Files.walk(directory)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
    }

    @Test
    public void testInit() {
        // Call the init method
        repository.init();

        // Check if the .gitlet directory was created
        File gitletDir = new File(GITLET_DIR);
        assertTrue(gitletDir.exists());
        assertTrue(gitletDir.isDirectory());

        //Check if the master and head files were created

        // TODO - Andre
    }

}

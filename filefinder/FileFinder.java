package filefinder;

import java.io.File;
import java.io.IOException;

/**
 * Find a file recursively.
 *
 * @author Hendrik Werner // s4549775
 * @author Sjaak Smetsers (?)
 */
public class FileFinder {

    private final File rootDir;

    public FileFinder(String root) throws IOException {
        rootDir = new File(root);
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory.");
        }
    }

    public void findFile(String file) {
        new Thread(new FolderSearcher(rootDir, file)).start();
    }

}

package filefinder;

import java.io.File;
import java.io.IOException;

/**
 * Find a file recursively.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 * @author Sjaak Smetsers (?)
 */
public class FileFinder {

    private final File rootDir;

    /**
     * @param root the path of the root folder
     */
    public FileFinder(String root) throws IOException {
        rootDir = new File(root);
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory.");
        }
    }

    /**
     * Find a file in the root directory.
     *
     * @param file the file name to search for
     */
    public void findFile(String file) {
        new Thread(new FolderSearcher(rootDir, file)).start();
    }

}

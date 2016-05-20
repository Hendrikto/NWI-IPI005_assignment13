package filefinder;

import java.io.File;

/**
 * Search a folder for a file.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class FolderSearcher implements Runnable {

    private final String fileName;
    private final File folder;

    /**
     * @param folder the folder to search in
     * @param fileName the file name to search for
     */
    public FolderSearcher(File folder, String fileName) {
        this.folder = folder;
        this.fileName = fileName;
    }

    /**
     * Search for the specified file.
     */
    @Override
    public void run() {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("Found at: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    new Thread(new FolderSearcher(file, fileName)).start();
                }
            }
        }
    }

}

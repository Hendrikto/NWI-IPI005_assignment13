package filefinder;

import java.io.File;

/**
 * Search a folder for a file.
 *
 * @author Hendrik Werner // s4549775
 */
public class FolderSearcher implements Runnable {

    private final String fileName;
    private final File folder;

    public FolderSearcher(File folder, String fileName) {
        this.folder = folder;
        this.fileName = fileName;
    }

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

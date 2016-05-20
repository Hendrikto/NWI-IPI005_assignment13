package assignment13;

import filefinder.FileFinder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Test the file finder and sorting algorithms.
 *
 * @author Hendrik Werner // s4549775
 */
public class Assignment13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testFileFinder();
    }

    private static void testFileFinder() {
        try {
            new FileFinder("C:\\").findFile("FileFinder.java");
        } catch (IOException ex) {
            Logger.getLogger(Assignment13.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

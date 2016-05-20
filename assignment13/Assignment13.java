package assignment13;

import filefinder.FileFinder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mergesort.MergeSort;
import mergesort.Sorter;

/**
 *
 * @author Hendrik Werner // s4549775
 */
public class Assignment13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
//            new FileFinder("C:\\").findFile("FileFinder.java");
//        } catch (IOException ex) {
//            Logger.getLogger(Assignment13.class.getName()).log(Level.SEVERE, null, ex);
//        }

        int[] ints = new int[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = (int) (Math.random() * 128);
        }
//        MergeSort.sort(ints);
        Thread t = new Thread(new Sorter(ints));
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Assignment13.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + ints[i]);
        }
    }

}

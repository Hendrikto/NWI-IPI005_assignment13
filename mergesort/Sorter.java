package mergesort;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sort an array of integers.
 *
 * @author Hendrik Werner // s4549775
 */
public class Sorter implements Runnable {

    private static final int THRESHOLD = 250000;

    private final int[] array;

    /**
     * @param array the array to sort
     */
    public Sorter(int[] array) {
        this.array = array;
    }

    /**
     * Sort the array.
     */
    @Override
    public void run() {
        if (array.length > THRESHOLD) {
            Sorter s1 = new Sorter(Arrays.copyOf(array, array.length / 2));
            Sorter s2 = new Sorter(Arrays.copyOfRange(array, array.length / 2, array.length));
            Thread t1 = new Thread(s1);
            Thread t2 = new Thread(s2);
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Sorter.class.getName()).log(Level.SEVERE, null, ex);
            }
            MergeSort.merge(s1.getArray(), s2.getArray(), array);
        } else {
            MergeSort.sort(array);
        }
    }

    /**
     * @return the array
     */
    private int[] getArray() {
        return array;
    }

}

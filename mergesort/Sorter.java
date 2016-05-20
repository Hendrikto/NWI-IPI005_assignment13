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

    private static final int THRESHOLD = 1000;

    private final int[] array;

    public Sorter(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        if (array.length > THRESHOLD) {
            Sorter s1 = new Sorter(
                    Arrays.copyOf(array, array.length / 2)
            );
            Sorter s2 = new Sorter(
                    Arrays.copyOfRange(array, array.length / 2, array.length)
            );
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
            System.arraycopy(s1.getArray(), 0, array, 0, s1.getArray().length);
            System.arraycopy(s2.getArray(), 0, array, s1.getArray().length, s2.getArray().length);
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

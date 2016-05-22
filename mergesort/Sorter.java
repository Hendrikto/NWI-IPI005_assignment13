package mergesort;

import assignment13.Assignment13;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sort an array of integers.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Sorter implements Runnable {

    private static final int THRESHOLD = Assignment13.ARRAY_SIZE / 4;

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
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
            Sorter s1 = new Sorter(Arrays.copyOf(array, array.length / 2));
            Sorter s2 = new Sorter(Arrays.copyOfRange(array, array.length / 2, array.length));
            Future f1 = executor.submit(s1);
            Future f2 = executor.submit(s2);
            try {
                f1.get();
                f2.get();
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Sorter.class.getName()).log(Level.SEVERE, null, ex);
            }
            executor.shutdown();
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

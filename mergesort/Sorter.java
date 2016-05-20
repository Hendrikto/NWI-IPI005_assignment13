package mergesort;

import java.util.Arrays;

/**
 * Sort an array of integers.
 *
 * @author Hendrik Werner // s4549775
 */
public class Sorter implements Runnable {

    private final int[] array;

    public Sorter(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        if (array.length > 1) {
            // todo
        }
    }

}

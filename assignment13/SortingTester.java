package assignment13;

import java.util.Arrays;
import mergesort.MergeSort;

/**
 * Test sorting an array with different methods.
 *
 * @author Hendrik Werner // s4549775
 */
public class SortingTester {

    private final int[] array;

    public SortingTester(int size) {
        this.array = random(size);
    }

    public void test() {
        System.out.printf(
                "This system has %d available cores.\n",
                Runtime.getRuntime().availableProcessors()
        );
        int[] a1 = Arrays.copyOf(array, array.length);
        int[] a2 = Arrays.copyOf(array, array.length);
        long startSeq = System.currentTimeMillis();
        MergeSort.sort(a1);
        long stopSeq = System.currentTimeMillis();
        long startCon = System.currentTimeMillis();
        MergeSort.concurrentSort(a2);
        long stopCon = System.currentTimeMillis();
        System.out.printf("Sequential sorting took %d ms\n", stopSeq - startSeq);
        System.out.printf("Concurrent sorting took %d ms\n", stopCon - startCon);
    }

    private int[] random(int size) {
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }
        return ints;
    }

}

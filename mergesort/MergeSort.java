package mergesort;

import java.util.Arrays;

/**
 * Sort an array of integers in O(n log n).
 *
 * @author Hendrik Werner // s4549775
 * @author Sjaak Smetsers (?)
 */
public class MergeSort {

    /**
     * Sort the given array in O(n log n) time. The array is split in to two
     * parts of equal size. These parts are sorted recursively and merged.
     *
     * @param array
     */
    public static void sort(int[] array) {
        if (array.length > 1) {
            int[] firstHalf = Arrays.copyOf(array, array.length / 2);
            int[] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);
            sort(firstHalf);
            sort(secondHalf);
            merge(firstHalf, secondHalf, array);
        }
    }

    /**
     * Merge two sorted arrays in O(N).
     *
     * @param part1 a sorted array 2
     * @param part2 a sorted array
     * @param dest destination, length must be >= part1.length + part2.length
     */
    public static void merge(int[] part1, int[] part2, int[] dest) {
        int part1Index = 0, part2Index = 0, destIndex = 0;
        while (part1Index < part1.length && part2Index < part2.length) {
            if (part1[part1Index] < part2[part2Index]) {
                dest[destIndex++] = part1[part1Index++];
            } else {
                dest[destIndex++] = part2[part2Index++];
            }
        }
        while (part1Index < part1.length) {
            dest[destIndex++] = part1[part1Index++];
        }
        while (part2Index < part2.length) {
            dest[destIndex++] = part2[part2Index++];
        }
    }

}

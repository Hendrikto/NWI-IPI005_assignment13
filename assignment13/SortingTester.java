package assignment13;

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
        // todo
    }

    private int[] random(int size) {
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }
        return ints;
    }

}

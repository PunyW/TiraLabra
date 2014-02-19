package tiralabra.algorithms;

/**
 *
 * @author Joel
 */
public class CountingSort {

    /**
     * Sort the array using the method of counting sort.
     *
     * @param a Array to be sorted
     * @param amountOfPossibleNumbers What is the largest number that is held
     * within the array
     */
    public static void sort(int[] a, int amountOfPossibleNumbers) {
        int k = amountOfPossibleNumbers + 1;

        int[] c = new int[k];
        int[] b = new int[a.length];

        /**
         * Init array c
         */
        for (int i = 0; i < k; i++) {
            c[i] = 0;
        }

        /**
         * Count how often each number n appears in the original array
         */
        for (int i = 0; i < a.length - 1; i++) {
            int x = a[i];
            c[x] = c[x] + 1;
        }

        /**
         * How often smaller or equal than i numbers there is in the array
         */
        for (int i = 1; i < k; i++) {
            c[i] = c[i] + c[i - 1];
        }

        /**
         * Arrange nodes from array a to the array b, going starting to sort the
         * array from a[n], where n = length of the array down to a[0]. c[x],
         * where x = i holds the data for how often smaller or equal than x
         * appears in the array.
         */
        for (int i = a.length - 1; i >= 0; i--) {
            int x = a[i];
            b[c[x]] = x;
            c[x] = c[x] - 1;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
    }
}

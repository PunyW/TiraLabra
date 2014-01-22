package tiralabra.algorithms;

/**
 *
 * @author Joel
 */
public class MergeSort {

    /**
     * Sort an array of integers using the method of merge sort.
     *
     * @param A Array to be sorted
     */
    public void sort(int[] A) {
        sort(A, 0, A.length);
    }

    /**
     * Private method for the sorting. that has the left and right parameters.
     *
     * @param A Array to be sorted
     * @param left left side of divider
     * @param right right side of the divider
     */
    private void sort(int[] A, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(A, left, middle);
            sort(A, middle + 1, right);
            merge(A, left, middle, right);

        }
    }

    /**
     * Merge the divided arrays back and sort them while doing it.
     * <p>
     * Copy array A[left + 1, middle] to new array L[] and A[middle, right] to
     * new array R[]. And from here start placing the i = 0 A[i] the smaller
     * integer from L[0] and R[0], after which increment i with one. If L[0] was
     * added to the A[i], next add the smaller integer from L[1] and R[0] to
     * A[i]
     * </p>
     *
     *
     * @param A Array to be merged
     * @param left left side of the array
     * @param middle middle of the array
     * @param right right side of the array
     */
    private void merge(int[] A, int left, int middle, int right) {
        int n1 = middle - left;
        int n2 = right - middle;
        // Create new arrays L, R and copy the values from A
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[left + i];
        }
        L[n1] = Integer.MAX_VALUE;

        for (int i = 0; i < n2; i++) {
            R[i] = A[middle + i];
        }
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = left; k < right; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                ++i;
            } else {
                A[k] = R[j];
                ++j;
            }
        }
    }
}

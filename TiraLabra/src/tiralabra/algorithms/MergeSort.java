package tiralabra.algorithms;

/**
 * Class that sorts array consisting of integers using merge sort
 *
 * @author Joel
 */
public class MergeSort {

    private static int[] temp;

    /**
     * Sort an consisting of integers using merge sort
     *
     * @param A Array to be sorted
     */
    public static void sort(int[] A) {
        temp = new int[A.length];
        sort(A, 0, A.length - 1);
    }

    /**
     * Recursively call the sort to sort two halves of the array
     *
     * @param A array to be sorted
     * @param left left side boundary of the recursive sorting
     * @param right right side boundary of the recursive sorting
     */
    private static void sort(int[] A, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            sort(A, left, middle);
            sort(A, middle + 1, right);

            merge(A, left, middle + 1, right);
        }
    }

    /**
     * Merge the divided arrays back and sort them while doing it.
     * <p>
     * Copy left and right side of the array into an temp array temp. Copy the
     * smallest values from either left or right side of the temp array back
     * into the original target array.
     *
     * @param A Array to be merged
     * @param left left side of the array
     * @param middle middle of the array
     * @param right right side of the array
     */
    private static void merge(int[] A, int left, int middle, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = A[i];
        }

        int leftEnd = middle - 1;
        int k = left;

        while (left <= leftEnd && middle <= right) {
            if (temp[left] <= temp[middle]) {
                A[k++] = temp[left++];
            } else {
                A[k++] = temp[middle++];
            }
        }

        while (left <= leftEnd) {
            A[k++] = temp[left++];
        }
    }
}

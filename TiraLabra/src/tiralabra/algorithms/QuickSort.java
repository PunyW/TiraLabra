package tiralabra.algorithms;

/**
 *
 * @author Joel
 */
public class QuickSort {

    /**
     * Sort an array using quick sort method.
     *
     * @param A Array to be sorted
     */
    public static void sort(int[] A) {
        // For arrays larger than 100 000 check if it's already sorted
        if (A.length > 100000) {
            if (checkIfSorted(A)) {
                return;
            }
        }
        sort(A, 0, A.length - 1);
    }

    private static void sort(int[] A, int left, int right) {
        if (left < right) {
            int pivot = partition(A, left, right);
            sort(A, left, pivot);
            sort(A, pivot + 1, right);
        }
    }

    /**
     * Check that if the array given for sorting is already sorted
     *
     * @param A Array to be checked
     * @return True if the array is sorted otherwise false
     */
    private static boolean checkIfSorted(int[] A) {

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Get the pivot point where the array will be divided into two parts.
     *
     * @param A Array
     * @param left starting position of the partitioning
     * @param right ending position of the partitioning
     * @return pivot index
     */
    private static int partition(int[] A, int left, int right) {
        int pivot = A[left];
        int i = left - 1;
        int j = right + 1;

        while (i < j) {
            i++;
            j--;
            while (A[j] > pivot) {
                j--;
            }
            while (A[i] < pivot) {
                i++;
            }
            if (i < j) {
                swap(A, i, j);
            }
        }
        return j;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}

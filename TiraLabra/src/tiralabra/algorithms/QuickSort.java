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

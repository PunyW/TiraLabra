package tiralabra.algorithms;

import java.util.Arrays;

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
    public static void sort(int[] A) {
        int length = 1;
        while (length < A.length) {
            int start = 0;
            while (start + length <= A.length) {
                int left = start;
                int middle = start + length - 1;
                int right = Math.min(middle + length, A.length - 1);
                merge(A, left, middle, right);
                start = start + 2 * length;
            }
            length *= 2;
        }
    }

    /**
     * Merge the divided arrays back and sort them while doing it.
     * <p> Copy left and right side of the array into an temp array temp. Copy 
     * the smallest values from either left or right side of the temp array
     * back into the original target array. 
     *
     * @param A Array to be merged
     * @param left left side of the array
     * @param middle middle of the array
     * @param right right side of the array
     */
    private static void merge(int[] A, int left, int middle, int right) {
        int[] temp = new int[left + right + 1];

        for (int i = left; i <= right; i++) {
            temp[i] = A[i];
        }

        int i = left;
        int j = middle + 1;
        int k = i;

        while (i <= middle && j <= right) {
            if (temp[i] <= temp[j]) {
                A[k] = temp[i];
                i++;
            } else {
                A[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            A[k] = temp[i];
            k++;
            i++;
        }
    }
}

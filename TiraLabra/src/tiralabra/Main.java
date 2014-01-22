package tiralabra;

import java.util.Arrays;
import tiralabra.algorithms.BubbleSort;
import tiralabra.algorithms.HeapSort;
import tiralabra.algorithms.MergeSort;

/**
 *
 * @author Joel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] test1 = new int[]{1, 5, 6, 23, 32, 51, 8};
        int[] test2 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] test3 = new int[]{10, 5, 25, 78, 9, 11, 20, 35, 44, 55, 10};

        BubbleSort.sort(test1);
        HeapSort.sort(test2);
        MergeSort.sort(test3);

        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));

    }

}

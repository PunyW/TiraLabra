package tiralabra.algorithms;

/**
 *
 * @author Joel
 */
public class BubbleSort {

    /**
     * Sort an array of integers
     *
     * @param list list to be sorted
     */
    public void sort(int[] list) {

        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

}

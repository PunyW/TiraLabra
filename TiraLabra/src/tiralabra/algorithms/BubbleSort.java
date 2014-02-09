package tiralabra.algorithms;

/**
 *
 * @author Joel
 */
public class BubbleSort {

    /**
     * Sort an array of integers using the bubble sort method. Go through the
     * list as long as sorted equals to false, check that if list[current] is
     * larger than list[next], swap current and next with each other, and change
     * sorted into false.
     *
     * @param list list to be sorted
     */
    public static void sort(int[] list) {

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

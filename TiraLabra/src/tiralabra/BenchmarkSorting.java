package tiralabra;

import java.util.Random;
import tiralabra.algorithms.BubbleSort;
import tiralabra.algorithms.HeapSort;
import tiralabra.algorithms.MergeSort;

/**
 * Class to run through all the sorting algorithms and benchmark their
 * effectiveness
 *
 * @author Joel
 */
public class BenchmarkSorting {

    private long bubbleTime;
    private long mergeTime;
    private long heapTime;

    private final int arraySize;

    /**
     *
     * @param arraySize the size of the testing arrays
     */
    public BenchmarkSorting(int arraySize) {
        this.arraySize = arraySize;
        bubbleTime = 0;
        mergeTime = 0;
        heapTime = 0;
    }

    /**
     * Loop through multiple tests with all the algorithms, and get their
     * average spent time sorting an array
     *
     */
    public void run() {
        for (int i = 0; i < 10; i++) {
            // Get new random array and copy it for all the sorting algorithms,
            // heap sort sorts the original test array
            int[] testArray = randomizeArray();
            int[] bubbleArray = testArray;
            int[] mergeArray = testArray;

            testBubble(bubbleArray);
            testMerge(mergeArray);
            testHeap(testArray);

        }
        long bubbleAverage = bubbleTime / 10;
        long mergeAverage = mergeTime / 10;
        long heapAverage = heapTime / 10;

        System.out.println("Bubble Sort average: " + bubbleAverage);
        System.out.println("Merge Sort average: " + mergeAverage);
        System.out.println("Heap Sort average: " + heapAverage);
    }

    /**
     * Method to get new randomized array with the size of arraySize
     *
     * @return new random array
     */
    private int[] randomizeArray() {
        int[] testArray = new int[arraySize];
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            testArray[i] = random.nextInt(1000000);
        }
        return testArray;
    }

    private void testBubble(int[] testArray) {
        long startTime = System.currentTimeMillis();
        BubbleSort.sort(testArray);

        long stopTime = System.currentTimeMillis();
        long elapsed = stopTime - startTime;
        bubbleTime += elapsed;
    }

    private void testMerge(int[] testArray) {
        long startTime = System.currentTimeMillis();
        MergeSort.sort(testArray);

        long stopTime = System.currentTimeMillis();
        long elapsed = stopTime - startTime;
        mergeTime += elapsed;

    }

    private void testHeap(int[] testArray) {
        long startTime = System.currentTimeMillis();
        HeapSort.sort(testArray);

        long stopTime = System.currentTimeMillis();
        long elapsed = stopTime - startTime;
        heapTime += elapsed;
    }

}

package tiralabra;

import java.util.Arrays;
import java.util.Random;
import tiralabra.algorithms.BubbleSort;
import tiralabra.algorithms.HeapSort;
import tiralabra.algorithms.MergeSort;
import tiralabra.algorithms.QuickSort;

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
    private long quickTime;
    private long standardTime;

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
        quickTime = 0;
        standardTime = 0;
    }

    /**
     * Loop through multiple tests with all the algorithms, and get their
     * average spent time sorting an array
     *
     */
    public void run() {
        for (int i = 0; i < 10; i++) {
            // Get new random array and copy it for all the sorting algorithms,
            // Arrays.sort tests the original testArray
            int[] testArray = randomizeArray();
            int[] bubbleArray = testArray;
            int[] mergeArray = testArray;
            int[] heapArray = testArray;
            int[] quickArray = testArray;

            testBubble(bubbleArray);
            testMerge(mergeArray);
            testHeap(heapArray);
            testQuick(quickArray);
            testStandard(testArray);

        }
        long bubbleAverage = bubbleTime / 10;
        long mergeAverage = mergeTime / 10;
        long heapAverage = heapTime / 10;
        long quickAverage = quickTime / 10;
        long standardAverage = standardTime / 10;

        System.out.println("Bubble Sort average: " + bubbleAverage);
        System.out.println("Merge Sort average: " + mergeAverage);
        System.out.println("Heap Sort average: " + heapAverage);
        System.out.println("Quick Sort average: " + quickAverage);
        System.out.println("Arrays.sort average: " + standardAverage);
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

    private void testQuick(int[] testArray) {
        long startTime = System.currentTimeMillis();
        QuickSort.sort(testArray);

        long stopTime = System.currentTimeMillis();
        long elapsed = stopTime - startTime;
        quickTime += elapsed;
    }

    private void testStandard(int[] testArray) {
        long startTime = System.currentTimeMillis();
        Arrays.sort(testArray);

        long stopTime = System.currentTimeMillis();
        long elapsed = stopTime - startTime;
        standardTime += elapsed;
    }

}

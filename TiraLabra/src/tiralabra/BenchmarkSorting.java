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

    private long bubbleTime, mergeTime, heapTime, quickTime, standardTime;
    private long bubbleAvg, mergeAvg, heapAvg, quickAvg, standardAvg;
    private final int arraySize;
    private final int loops = 10;

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
        int[] testArray = null;

        for (int i = 0; i < loops; i++) {
            // Get new random array and copy it for all the sorting algorithms,
            // Arrays.sort tests the original testArray
            testArray = randomizeArray();
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

        System.out.println("================================================");
        System.out.println("Average time used in milliseconds to sort an array\n"
                + "with " + arraySize + " items.");
        System.out.println("================================================");
        calculateAverages();
        printStats();

        testBubble(testArray);
        testMerge(testArray);
        testHeap(testArray);
        testQuick(testArray);
        testStandard(testArray);

        System.out.println("================================================");
        System.out.println("Time in milliseconds it took to sort an already\n"
                + "sorted array with " + arraySize + " items.");
        System.out.println("================================================");
        calculateAverages();
        printStats();
    }

    private void calculateAverages() {
        bubbleAvg = bubbleTime / loops;
        mergeAvg = mergeTime / loops;
        heapAvg = heapTime / loops;
        quickAvg = quickTime / loops;
        standardAvg = standardTime / loops;

        bubbleTime = 0;
        mergeTime = 0;
        heapTime = 0;
        quickTime = 0;
        standardTime = 0;
    }

    private void printStats() {
        System.out.println("Bubble Sort average: " + bubbleAvg);
        System.out.println("Merge Sort average: " + mergeAvg);
        System.out.println("Heap Sort average: " + heapAvg);
        System.out.println("Quick Sort average: " + quickAvg);
        System.out.println("Arrays.sort average: " + standardAvg);
        System.out.println("");
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

    /**
     * Method to test how long it takes for bubble sort to sort the array in
     * milliseconds. Get the system time before calling sort and catch the
     * system time after the call finishes and calculate time taken based on
     * that.
     *
     * @param testArray Array to be sorted
     */
    private void testBubble(int[] testArray) {
        long startTime = System.currentTimeMillis();
        BubbleSort.sort(testArray);

        long stopTime = System.currentTimeMillis();
        long elapsed = stopTime - startTime;
        bubbleTime += elapsed;
    }

    /**
     * Method to test how long it takes for merge sort to sort the array in
     * milliseconds. Get the system time before calling sort and catch the
     * system time after the call finishes and calculate time taken based on
     * that.
     *
     * @param testArray Array to be sorted
     */
    private void testMerge(int[] testArray) {
        long startTime = System.currentTimeMillis();
        MergeSort.sort(testArray);

        long stopTime = System.currentTimeMillis();
        long elapsed = stopTime - startTime;
        mergeTime += elapsed;

    }

    /**
     * Method to test how long it takes for heap sort to sort the array in
     * milliseconds. Get the system time before calling sort and catch the
     * system time after the call finishes and calculate time taken based on
     * that.
     *
     * @param testArray Array to be sorted
     */
    private void testHeap(int[] testArray) {
        long startTime = System.currentTimeMillis();
        HeapSort.sort(testArray);

        long stopTime = System.currentTimeMillis();
        long elapsed = stopTime - startTime;
        heapTime += elapsed;
    }

    /**
     * Method to test how long it takes for quick sort to sort the array in
     * milliseconds. Get the system time before calling sort and catch the
     * system time after the call finishes and calculate time taken based on
     * that.
     *
     * @param testArray Array to be sorted
     */
    private void testQuick(int[] testArray) {
        long startTime = System.currentTimeMillis();
        QuickSort.sort(testArray);

        long stopTime = System.currentTimeMillis();
        long elapsed = stopTime - startTime;
        quickTime += elapsed;
    }

    /**
     * Method to test how long it takes for Arrays.sort to sort the array in
     * milliseconds. Get the system time before calling sort and catch the
     * system time after the call finishes and calculate time taken based on
     * that.
     *
     * @param testArray Array to be sorted
     */
    private void testStandard(int[] testArray) {
        long startTime = System.currentTimeMillis();
        Arrays.sort(testArray);

        long stopTime = System.currentTimeMillis();
        long elapsed = stopTime - startTime;
        standardTime += elapsed;
    }

}

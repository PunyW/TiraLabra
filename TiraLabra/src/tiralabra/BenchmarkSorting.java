package tiralabra;

import java.util.Arrays;
import java.util.Random;
import tiralabra.algorithms.BubbleSort;
import tiralabra.algorithms.CountingSort;
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

    private long bubbleTime, mergeTime, heapTime, quickTime, countingTime, standardTime;
    private long bubbleAvg, mergeAvg, heapAvg, quickAvg, countingAvg, standardAvg;
    private final int arraySize;
    private final int loops = 10;
    private final int maxInt = 9999999;

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
        countingTime = 0;
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
            int[] bubbleArray = Arrays.copyOf(testArray, arraySize);
            int[] mergeArray = Arrays.copyOf(testArray, arraySize);
            int[] heapArray = Arrays.copyOf(testArray, arraySize);
            int[] quickArray = Arrays.copyOf(testArray, arraySize);
            int[] countArray = Arrays.copyOf(testArray, arraySize);

            testBubble(bubbleArray);
            testMerge(mergeArray);
            testHeap(heapArray);
            testQuick(quickArray);
            testCounting(countArray);
            testStandard(testArray);
        }

        System.out.println("================================================");
        System.out.println("Average time used in milliseconds to sort an array\n"
                + "with " + arraySize + " items.");
        System.out.println("================================================");
        calculateAverages();
        printStats();

//        testBubble(testArray);
//        testMerge(testArray);
//        testHeap(testArray);
//        testQuick(testArray);
//        testStandard(testArray);
//        testCounting(testArray);
//
//        System.out.println("================================================");
//        System.out.println("Time in milliseconds it took to sort an already\n"
//                + "sorted array with " + arraySize + " items.");
//        System.out.println("================================================");
//        calculateAverages();
//        printStats();
    }

    private void calculateAverages() {
        bubbleAvg = bubbleTime / loops;
        mergeAvg = mergeTime / loops;
        heapAvg = heapTime / loops;
        quickAvg = quickTime / loops;
        standardAvg = standardTime / loops;
        countingAvg = countingTime / loops;

        bubbleTime = 0;
        mergeTime = 0;
        heapTime = 0;
        quickTime = 0;
        standardTime = 0;
    }

    private void printStats() {
        System.out.println("Bubble Sort: " + bubbleAvg / 1000000);
        System.out.println("Merge Sort: " + mergeAvg / 1000000);
        System.out.println("Heap Sort: " + heapAvg / 1000000);
        System.out.println("Quick Sort: " + quickAvg / 1000000);
        System.out.println("Counting Sort: " + countingAvg / 1000000);
        System.out.println("Arrays.sort: " + standardAvg / 1000000);
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
            testArray[i] = random.nextInt(maxInt);
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
        long startTime = System.nanoTime();
        BubbleSort.sort(testArray);

        long stopTime = System.nanoTime();
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
        long startTime = System.nanoTime();
        MergeSort.sort(testArray);

        long stopTime = System.nanoTime();
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
        long startTime = System.nanoTime();
        HeapSort.sort(testArray);

        long stopTime = System.nanoTime();
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
        long startTime = System.nanoTime();
        QuickSort.sort(testArray);

        long stopTime = System.nanoTime();
        long elapsed = stopTime - startTime;
        quickTime += elapsed;
    }

    /**
     * Method to test how long it takes for counting sort to sort the array in
     * milliseconds. Get the system time before calling sort and catch the
     * system time after the call finishes and calculate time taken based on
     * that.
     *
     * @param testArray Array to be sorted
     */
    private void testCounting(int[] testArray) {
        long startTime = System.nanoTime();
        CountingSort.sort(testArray, maxInt);

        long stopTime = System.nanoTime();
        long elapsed = stopTime - startTime;
        countingTime += elapsed;
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
        long startTime = System.nanoTime();
        Arrays.sort(testArray);

        long stopTime = System.nanoTime();
        long elapsed = stopTime - startTime;
        standardTime += elapsed;
    }

}

package tiralabra;

import java.util.Arrays;
import java.util.Random;
import tiralabra.algorithms.BubbleSort;
import tiralabra.algorithms.CountingSort;
import tiralabra.algorithms.HeapSort;
import tiralabra.algorithms.MergeSort;
import tiralabra.algorithms.QuickSort;
import tiralabra.gui.GUI;

/**
 * Class to run through all the sorting algorithms and benchmark their
 * effectiveness
 *
 * @author Joel
 */
public class Benchmark {

    private long bubbleTime, mergeTime, heapTime, quickTime, countingTime, standardTime;
    private long bubbleAvg, mergeAvg, heapAvg, quickAvg, countingAvg, standardAvg;
    private int arraySize;
    private int loops = 10;
    private boolean bubble, merge, heap, quick, counting, standard, testSorted;
    private int currentLoop = 1;

    /**
     *
     * @param arraySize the size of the testing arrays
     */
    public Benchmark() {
        this.arraySize = 100000;
        bubbleTime = 0;
        mergeTime = 0;
        heapTime = 0;
        quickTime = 0;
        countingTime = 0;
        standardTime = 0;
        bubble = merge = heap = quick = counting = standard = true;
        testSorted = false;
    }

    public void setSize(int size) {
        this.arraySize = size;
    }

    public void setLoops(int size) {
        loops = size;
    }

    public void test() {
        System.out.println(arraySize);
        System.out.println(loops);
    }

    public void setTestSorted(boolean enabled) {
        testSorted = enabled;
    }

    public void setBubble(boolean enabled) {
        bubble = enabled;
    }

    public void setMerge(boolean enabled) {
        merge = enabled;
    }

    public void setHeap(boolean enabled) {
        heap = enabled;
    }

    public void setQuick(boolean enabled) {
        quick = enabled;
    }

    public void setCounting(boolean enabled) {
        counting = enabled;
    }

    public void setStandard(boolean enabled) {
        standard = enabled;
    }

    public void startTest() {
        System.out.println("Starting to sort array with size of " + arraySize);
        System.out.println("Going through " + loops + " loops");
        System.out.println("Algorithms enabled: ");
        System.out.println("\tBubble: " + bubble);
        System.out.println("\tMerge: " + merge);
        System.out.println("\tHeap: " + heap);
        System.out.println("\tQuick: " + quick);
        System.out.println("\tCounting: " + counting);
        System.out.println("\tArrays.sort: " + standard);
        System.out.println("Test Sorted is " + testSorted);
    }

    /**
     * Loop through multiple tests with all the algorithms, and get their
     * average spent time sorting an array
     *
     * @param disableBubble If sorting huge arrays it might be advisable to
     * disable bubble sorting.
     */
    public void run(boolean disableBubble) {
        int[] testArray = null;

        for (int i = 0; i < loops; i++) {
            // Get new random array and copy it for all the sorting algorithms,
            // Arrays.sort tests the original testArray
            testArray = randomizeArray();

            int[] mergeArray = Arrays.copyOf(testArray, arraySize);
            int[] heapArray = Arrays.copyOf(testArray, arraySize);
            int[] quickArray = Arrays.copyOf(testArray, arraySize);
            int[] countArray = Arrays.copyOf(testArray, arraySize);

            if (!disableBubble) {
                int[] bubbleArray = Arrays.copyOf(testArray, arraySize);
                testBubble(bubbleArray);
            }
            
            testMerge(mergeArray);
            testHeap(heapArray);
            testQuick(quickArray);
            testCounting(countArray);
            testStandard(testArray);

            currentLoop++;
        }
        currentLoop = 1;
    }

    public int getCurrentLoop() {
        return currentLoop;
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

    /**
     * Method to get new randomized array with the size of arraySize
     *
     * @return new random array
     */
    private int[] randomizeArray() {
        int[] testArray = new int[arraySize];
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            testArray[i] = random.nextInt(arraySize);
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
        CountingSort.sort(testArray, arraySize);

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

    public long getBubbleTime() {
        return bubbleTime;
    }

    public long getMergeTime() {
        return mergeTime;
    }

    public long getHeapTime() {
        return heapTime;
    }

    public long getQuickTime() {
        return quickTime;
    }

    public long getCountingTime() {
        return countingTime;
    }

    public long getStandardTime() {
        return standardTime;
    }

    public long getBubbleAvg() {
        return bubbleAvg;
    }

    public long getMergeAvg() {
        return mergeAvg;
    }

    public long getHeapAvg() {
        return heapAvg;
    }

    public long getQuickAvg() {
        return quickAvg;
    }

    public long getCountingAvg() {
        return countingAvg;
    }

    public long getStandardAvg() {
        return standardAvg;
    }

    
    
}

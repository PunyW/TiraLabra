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
    private long bubbleSorted, mergeSorted, heapSorted, quickSorted, countingSorted, standardSorted;
    private int arraySize;
    private int loops = 10;
    private boolean bubble, merge, heap, quick, counting, standard, testSorted;
    private GUI gui;

    /**
     *
     * @param arraySize the size of the testing arrays
     */
    public Benchmark() {
        arraySize = 100000;
        bubbleTime = mergeTime = heapTime = quickTime = countingTime = standardTime = 0;
        bubbleSorted = mergeSorted = heapSorted = quickSorted = countingSorted = standardSorted = 0;
        merge = heap = quick = counting = standard = true;
        testSorted = bubble = false;
    }

    public void setGUI(GUI gui) {
        this.gui = gui;
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

    public void startTest() {
        System.out.println("Starting to sort array with size of " + arraySize);
        System.out.println("Going through " + loops + " loops");
        System.out.println("");

        run();
    }

    /**
     * Loop through multiple tests with all the algorithms, and get their
     * average spent time sorting an array
     */
    public void run() {
        int[] testArray = null;

        for (int i = 0; i < loops; i++) {
            // Get new random array and copy it for all the sorting algorithms,
            // Arrays.sort tests the original testArray
            testArray = randomizeArray();

            if (bubble) {
                int[] bubbleArray = Arrays.copyOf(testArray, arraySize);
                testBubble(bubbleArray, false);
            }

            if (merge) {
                int[] mergeArray = Arrays.copyOf(testArray, arraySize);
                testMerge(mergeArray, false);
            }

            if (heap) {
                int[] heapArray = Arrays.copyOf(testArray, arraySize);
                testHeap(heapArray, false);
            }

            if (quick) {
                int[] quickArray = Arrays.copyOf(testArray, arraySize);
                testQuick(quickArray, false);
            }

            if (counting) {
                int[] countArray = Arrays.copyOf(testArray, arraySize);
                testCounting(countArray, false);

            }

            if (standard) {
                testStandard(testArray, false);
            }

        }

        if (testSorted) {
            testSortedArrays(testArray);
        }

        calculateAverages();
        gui.setLabelTexts();
        bubbleTime = heapTime = mergeTime = quickTime = countingTime = standardTime = 0;
    }

    private void testSortedArrays(int[] testArray) {
        testBubble(testArray, true);
        testHeap(testArray, true);
        testMerge(testArray, true);
        testQuick(testArray, true);
        testCounting(testArray, true);
        testStandard(testArray, true);

        gui.setSortedTexts();
    }

    private void calculateAverages() {
        bubbleAvg = bubbleTime / loops;
        mergeAvg = mergeTime / loops;
        heapAvg = heapTime / loops;
        quickAvg = quickTime / loops;
        standardAvg = standardTime / loops;
        countingAvg = countingTime / loops;
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
            testArray[i] = random.nextInt(arraySize * 2);
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
    private void testBubble(int[] testArray, boolean sorted) {
        long startTime = System.nanoTime();
        BubbleSort.sort(testArray);

        long stopTime = System.nanoTime();
        long elapsed = (stopTime - startTime) / 1000000;

        if (sorted) {
            bubbleSorted = elapsed;
        } else {
            bubbleTime += elapsed;
            gui.setBubbleText("" + elapsed);
        }
    }

    /**
     * Method to test how long it takes for merge sort to sort the array in
     * milliseconds. Get the system time before calling sort and catch the
     * system time after the call finishes and calculate time taken based on
     * that.
     *
     * @param testArray Array to be sorted
     */
    private void testMerge(int[] testArray, boolean sorted) {
        long startTime = System.nanoTime();
        MergeSort.sort(testArray);

        long stopTime = System.nanoTime();
        long elapsed = (stopTime - startTime) / 1000000;

        if (sorted) {
            mergeSorted = elapsed;
        } else {
            mergeTime += elapsed;
            gui.setMergeText("" + elapsed);
        }
    }

    /**
     * Method to test how long it takes for heap sort to sort the array in
     * milliseconds. Get the system time before calling sort and catch the
     * system time after the call finishes and calculate time taken based on
     * that.
     *
     * @param testArray Array to be sorted
     */
    private void testHeap(int[] testArray, boolean sorted) {
        long startTime = System.nanoTime();
        HeapSort.sort(testArray);

        long stopTime = System.nanoTime();
        long elapsed = (stopTime - startTime) / 1000000;

        if (sorted) {
            heapSorted = elapsed;
        } else {
            heapTime += elapsed;
            gui.setHeapText("" + elapsed);
        }
    }

    /**
     * Method to test how long it takes for quick sort to sort the array in
     * milliseconds. Get the system time before calling sort and catch the
     * system time after the call finishes and calculate time taken based on
     * that.
     *
     * @param testArray Array to be sorted
     */
    private void testQuick(int[] testArray, boolean sorted) {
        long startTime = System.nanoTime();
        QuickSort.sort(testArray);

        long stopTime = System.nanoTime();
        long elapsed = (stopTime - startTime) / 1000000;

        if (sorted) {
            quickSorted = elapsed;
        } else {
            quickTime += elapsed;
            gui.setQuickText("" + elapsed);
        }
    }

    /**
     * Method to test how long it takes for counting sort to sort the array in
     * milliseconds. Get the system time before calling sort and catch the
     * system time after the call finishes and calculate time taken based on
     * that.
     *
     * @param testArray Array to be sorted
     */
    private void testCounting(int[] testArray, boolean sorted) {
        long startTime = System.nanoTime();
        CountingSort.sort(testArray, arraySize * 2);

        long stopTime = System.nanoTime();
        long elapsed = (stopTime - startTime) / 1000000;

        if (sorted) {
            countingSorted = elapsed;
        } else {
            countingTime += elapsed;
            gui.setCountingText("" + elapsed);
        }
    }

    /**
     * Method to test how long it takes for Arrays.sort to sort the array in
     * milliseconds. Get the system time before calling sort and catch the
     * system time after the call finishes and calculate time taken based on
     * that.
     *
     * @param testArray Array to be sorted
     */
    private void testStandard(int[] testArray, boolean sorted) {
        long startTime = System.nanoTime();
        Arrays.sort(testArray);

        long stopTime = System.nanoTime();
        long elapsed = (stopTime - startTime) / 1000000;

        if (sorted) {
            standardSorted = elapsed;
        } else {
            standardTime += elapsed;
            gui.setStandardText("" + elapsed);
        }
    }

    public String getBubbleAvg() {
        if (bubbleAvg > 0) {
            return bubbleAvg + "";
        }
        return "-";
    }

    public String getMergeAvg() {
        if (mergeAvg >= 0) {
            return mergeAvg + "";
        }
        return "-";
    }

    public String getHeapAvg() {
        if (heapAvg >= 0) {
            return heapAvg + "";
        }
        return "-";
    }

    public String getQuickAvg() {
        if (quickAvg >= 0) {
            return quickAvg + "";
        }
        return "-";

    }

    public String getCountingAvg() {
        if (countingAvg >= 0) {
            return countingAvg + "";
        }
        return "-";
    }

    public String getStandardAvg() {
        if (standardAvg >= 0) {
            return standardAvg + "";
        }
        return "-";
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

    public String getBubbleSorted() {
        return bubbleSorted + "";
    }

    public String getMergeSorted() {
        return mergeSorted + "";
    }

    public String getHeapSorted() {
        return heapSorted + "";
    }

    public String getQuickSorted() {
        return quickSorted + "";
    }

    public String getCountingSorted() {
        return countingSorted + "";
    }

    public String getStandardSorted() {
        return standardSorted + "";
    }

}

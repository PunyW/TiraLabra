package tiralabra;

import java.util.Arrays;
import java.util.Random;
import tiralabra.heap.Heap;
import tiralabra.heap.MaxHeap;

/**
 *
 * @author Joel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Heap<Integer> heap = new MaxHeap<>(10);
        heap.insert(10);
        heap.insert(25);

        System.out.println(heap.remove());
        BenchmarkSorting benchmark = new BenchmarkSorting(1000000);
        benchmark.run(true);
        benchmark.setSize(10000);
        benchmark.run(false);

//        long startTime = System.nanoTime();
//        int[] test = randomizeArray(100);
//        BubbleSort.sort(test);
//        long stopTime = System.nanoTime();
//        long elapsed = stopTime - startTime;
//        System.out.println("Elapsed: " + elapsed / 1000000);
//        System.out.println(Arrays.toString(test));
    }

    private static int[] randomizeArray(int size) {
        int[] testArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            testArray[i] = random.nextInt(size);
        }
        return testArray;
    }

}

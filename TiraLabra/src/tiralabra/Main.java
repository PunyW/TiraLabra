package tiralabra;

import java.util.Random;
import java.util.Scanner;
import tiralabra.heap.Heap;
import tiralabra.heap.MaxHeap;
import tiralabra.heap.MinHeap;

/**
 *
 * @author Joel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("What do you want to test?");
            System.out.println("1: Heaps \t 2: Sorting Algorithms");
            System.out.println("Anything else quits");

            int input = Integer.parseInt(scanner.nextLine());

            if (input == 2) {

                BenchmarkSorting benchmark = new BenchmarkSorting(1000000);
                benchmark.run(true);
                benchmark.setSize(10000);
                benchmark.run(false);

            } else if (input == 1) {
                testHeaps();
            } else {
                System.exit(0);
            }
        }
    }

    private static void testHeaps() {
        Heap<Integer> maxHeap = new MaxHeap<>();
        maxHeap = randomizeHeapWithoutSame(10, maxHeap);

        Heap<Integer> minHeap = new MinHeap<>();
        minHeap = randomizeHeapWithSame(10, minHeap);

        System.out.println("======================================");
        System.out.println("Testing with randomized heaps with \nnumbers between 0 - 20");
        System.out.println("======================================");

        for (int i = 0; i < 10; i++) {
            System.out.print("Max Heap Removed: " + maxHeap.remove());
            System.out.println("\tMin Heap Removed: " + minHeap.remove());
        }

    }

    private static int[] randomizeArray(int size) {
        int[] testArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            testArray[i] = random.nextInt(size);
        }
        return testArray;
    }

    private static Heap<Integer> randomizeHeapWithoutSame(int size, Heap<Integer> heap) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int rnd = random.nextInt(size * 2);
            while (heap.contains(rnd)) {
                rnd = random.nextInt(size * 2);
            }
            heap.insert(rnd);
        }

        return heap;
    }

    private static Heap<Integer> randomizeHeapWithSame(int size, Heap<Integer> heap) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int rnd = random.nextInt(size * 2);
            heap.insert(rnd);
        }

        return heap;
    }

}

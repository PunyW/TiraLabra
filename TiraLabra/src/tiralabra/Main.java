package tiralabra;

import java.util.Arrays;
import java.util.Random;
import tiralabra.algorithms.QuickSort;

/**
 *
 * @author Joel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        BenchmarkSorting benchmark = new BenchmarkSorting(10000);
//        benchmark.run();
        int[] testArray = randomizeArray();
        System.out.println(Arrays.toString(testArray));
        QuickSort.sort(testArray);
        System.out.println(Arrays.toString(testArray));

    }

    private static int[] randomizeArray() {
        int[] testArray = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            testArray[i] = random.nextInt(100);
        }
        return testArray;
    }

}

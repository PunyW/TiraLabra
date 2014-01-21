package tiralabra;

import java.util.Arrays;
import tiralabra.algorithms.BubbleSort;

/**
 *
 * @author Joel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] test1 = new int[]{1, 5, 6, 23, 32, 51, 8};
        int[] test2 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        
        BubbleSort bubble = new BubbleSort();
        test1 = bubble.sort(test1);
        System.out.println(Arrays.toString(test1));
        
    }

}

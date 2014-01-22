package tiralabra.algorithms;

/**
 *
 * @author Joel
 */
public class CountingSort {

    public static void sort(int[] a, int amountOfPossibleNumbers) {
        int k = amountOfPossibleNumbers + 1;

        int[] c = new int[k];
        int[] b = new int[a.length];
        for (int i = 0; i < k; i++) {
            c[i] = 0;
        }

        for (int i = 0; i < a.length - 1; i++) {
            int x = a[i];
            c[x] = c[x] + 1;
        }

        for (int i = 1; i < k; i++) {
            c[i] = c[i] + c[i - 1];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            int x = a[i];
            b[c[x]] = x;
            c[x] = c[x] - 1;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
    }
}

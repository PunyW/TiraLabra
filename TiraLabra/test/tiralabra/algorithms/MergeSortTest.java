package tiralabra.algorithms;

import java.util.Random;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Joel
 */
public class MergeSortTest {

    private int[] testArray;
    private final int SIZE = 1000;
    private final int MAX = 100000;

    public MergeSortTest() {
    }

    @Before
    public void setUp() {
        testArray = new int[SIZE];
    }

    private void randomizeArray() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            testArray[i] = random.nextInt(MAX);
        }
    }

    @Test
    public void testMergeSort() {
        randomizeArray();

        MergeSort.sort(testArray);
        checkArray();
    }

    @Test
    public void worksRepeadetly() {
        for (int i = 0; i < 1000; i++) {
            randomizeArray();
            MergeSort.sort(testArray);
            checkArray();
        }
    }
    
    @Test
    public void checkSpecial() {
        int[] special = new int[]{1, 1, 1, 3, 3, 3, 1, 5, 5, 1};

        MergeSort.sort(special);
        for (int i = 0; i < special.length; i++) {
            if (testArray[i] > testArray[i + 1]) {
                fail("There should be no larger numbers before smaller ones, "
                        + "in the sorted array. ");
            }
        }
        assertTrue(true);
    }


    private void checkArray() {
        for (int i = 0; i < SIZE - 1; i++) {
            if (testArray[i] > testArray[i + 1]) {
                fail("There should be no larger numbers before smaller ones, "
                        + "in the sorted array. ");
            }
        }
        assertTrue(true);
    }
}

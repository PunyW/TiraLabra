/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.algorithms;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joel
 */
public class CountingSortTest {

    private int[] testArray;
    private final int SIZE = 1000;
    private final int MAX = 100000;

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
    public void testBubbleSort() {
        randomizeArray();

        CountingSort.sort(testArray, MAX);
        checkArray();
    }

    @Test
    public void worksRepeadetly() {
        for (int i = 0; i < 1000; i++) {
            randomizeArray();
            CountingSort.sort(testArray, MAX);
            checkArray();
        }
    }

    @Test
    public void checkSpecial() {
        int[] special = new int[]{1, 1, 1, 3, 3, 3, 1, 5, 5, 1};

        CountingSort.sort(special, 5);
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

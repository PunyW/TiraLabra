/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.algorithms;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joel
 */
public class HeapSortTest {

    private int[] testArray;
    private final int SIZE = 1000;
    private final int MAX = 100000;

    public HeapSortTest() {
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
    public void testHeapSort() {
        randomizeArray();

        HeapSort.sort(testArray);
        checkArray();
    }

    @Test
    public void worksRepeadetly() {
        for (int i = 0; i < 1000; i++) {
            randomizeArray();
            HeapSort.sort(testArray);
            checkArray();
        }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.heap;

import java.util.Random;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Joel
 */
public class MaxHeapTest {

    private Heap<Integer> heap;

    public MaxHeapTest() {
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        heap = randomizeHeap(10);
    }

    @Test
    public void testInsert() {
        Heap<Integer> maxHeap = new MaxHeap<>(3);
        assertEquals(true, maxHeap.insert(10));
        assertEquals(true, maxHeap.insert(11));
        assertEquals(true, maxHeap.insert(12));
        assertEquals(false, maxHeap.insert(12));
    }

    @Test
    public void insertThrowsNullPointerExceptionWithNull() {
        Heap<Integer> maxHeap = new MaxHeap<>(1);
        exception.expect(NullPointerException.class);
        exception.expectMessage("Can't insert null element");
        maxHeap.insert(null);
    }

    @Test
    public void constructorThrowsIllegalArgumentExceptionWithSizeUnderOne() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Initial capacity cannot be under");
        Heap<Integer> maxHeap = new MaxHeap<>(0);
    }

    private Heap<Integer> randomizeHeap(int size) {
        heap = new MaxHeap<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int rnd = random.nextInt(100);
            while (heap.contains(rnd)) {
                rnd = random.nextInt(100);
            }
            heap.insert(rnd);
        }

        return heap;
    }
}

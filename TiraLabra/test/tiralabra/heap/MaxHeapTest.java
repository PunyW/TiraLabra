/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.heap;

import java.util.Random;
import org.junit.Before;
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
        heap = randomizeHeap(10000);
    }

    @Test
    public void testInsert() {
        Heap<Integer> maxHeap = new MaxHeap<>(3);
        assertEquals(true, maxHeap.insert(10));
        assertEquals(true, maxHeap.insert(11));
        assertEquals(true, maxHeap.insert(12));
        testSize(3, maxHeap);
    }

    @Test
    public void insertGrowsSizeIfCapacityReached() {
        Heap<Integer> maxHeap = new MaxHeap<>(1);
        assertEquals(true, maxHeap.insert(10));
        assertEquals(true, maxHeap.insert(10));
        testSize(2, maxHeap);
    }

    @Test
    public void insertThrowsNullPointerExceptionWithNull() {
        Heap<Integer> maxHeap = new MaxHeap<>(1);
        exception.expect(NullPointerException.class);
        exception.expectMessage("Can't insert null element");
        maxHeap.insert(null);
        testSize(0, maxHeap);
    }

    @Test
    public void constructorThrowsIllegalArgumentExceptionWithSizeUnderOne() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Initial capacity cannot be under 1");
        Heap<Integer> maxHeap = new MaxHeap<>(0);
    }

    @Test
    public void testRemove() {
        Heap<Integer> maxHeap = new MaxHeap<>(2);
        maxHeap.insert(10);
        maxHeap.insert(25);
        assertEquals(25, (int) maxHeap.remove());
        assertEquals(10, (int) maxHeap.remove());
        testSize(0, maxHeap);
    }

    @Test
    public void testRandomHeap() {
        int prev = heap.remove();
        while (!heap.isEmpty()) {
            int current = heap.remove();
            if (prev < current) {
                fail("Items that are popped first should be the largest ones, "
                        + "now it wasn't so: current items value - "
                        + current + " is larger than previous item - " + prev);
            }
        }
        assertTrue(true);
        testSize(0);
    }

    @Test
    public void testGrow() {
        Heap<Integer> maxHeap = new MaxHeap<>(2);
        for (int i = 0; i < 100; i++) {
            maxHeap.add(i);
        }
        testSize(100, maxHeap);
    }
    
    @Test
    public void clearWorks() {
        heap.clear();
        testSize(0);
        assertEquals(null, heap.remove());
    }

    private Heap<Integer> randomizeHeap(int size) {
        heap = new MaxHeap<>(size);
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

    private void testSize(int size, Heap<Integer> maxHeap) {
        assertEquals(size, maxHeap.size());
    }

    private void testSize(int size) {
        assertEquals(size, heap.size());
    }

}

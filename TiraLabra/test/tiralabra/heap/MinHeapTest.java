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
public class MinHeapTest {

    private Heap<Integer> heap;

    public MinHeapTest() {
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        heap = randomizeHeap(10000);
    }

    @Test
    public void testInsert() {
        Heap<Integer> minHeap = new MinHeap<>(3);
        assertEquals(true, minHeap.insert(10));
        assertEquals(true, minHeap.insert(11));
        assertEquals(true, minHeap.insert(12));
        testSize(3, minHeap);
    }

    @Test
    public void insertThrowsNullPointerExceptionWithNull() {
        Heap<Integer> minHeap = new MinHeap<>(1);
        exception.expect(NullPointerException.class);
        exception.expectMessage("Can't insert null element");
        minHeap.insert(null);
        testSize(0, minHeap);
    }

    @Test
    public void peekWorks() {
        Heap<Integer> minHeap = new MinHeap<>();
        minHeap.add(10);
        minHeap.add(9);
        assertEquals(9, (int) minHeap.peek());
    }

    @Test
    public void constructorThrowsIllegalArgumentExceptionWithSizeUnderOne() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Initial capacity cannot be under 1");
        Heap<Integer> minHeap = new MinHeap<>(0);
    }

    @Test
    public void testRandomHeap() {
        int prev = heap.remove();
        while (!heap.isEmpty()) {
            int current = heap.pop();
            if (prev > current) {
                fail("Items that are popped first should be the largest ones, "
                        + "now it wasn't so: current items value - "
                        + current + " is larger than previous item - " + prev);
            }
        }
        assertTrue(true);
        testSize(0);
    }

    @Test
    public void clearWorks() {
        heap.clear();
        testSize(0);
        assertEquals(null, heap.remove());
    }

    private Heap<Integer> randomizeHeap(int size) {
        heap = new MinHeap<>(size);
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

package tiralabra.heap;

import java.util.Comparator;

/**
 *
 * @author Joel
 * @param <E> Type of elements held in this heap
 */
public class MaxHeap<E> extends AbstractHeap<E> {

    /**
     * Constructor for max heap that uses elements natural ordering for the
     * comparison and assigns heap capacity into DEFAULT_CAPACITY
     */
    public MaxHeap() {
        super(null, DEFAULT_CAPACITY);
    }

    /**
     * Constructor for max heap that uses elements natural ordering for the
     * comparison and heaps capacity is the given custom value
     *
     * @param capacity how many items the heap will take
     */
    public MaxHeap(int capacity) {
        super(null, capacity);
    }

    public MaxHeap(Comparator<? super E> comparator, int initialCapacity) {
        super(comparator, initialCapacity);
    }

    /**
     * Check that heap invariant is met at the given index. Method checks that
     * node isn't smaller than either of it's children, if it is swap it with
     * it's children and call heapify at the child's index.
     *
     * To make the code cleaner heapify with comparator has been split from
     * heapify without comparator even though both are otherwise identical.
     *
     * @param nodeIndex inspected nodes index
     */
    @Override
    public void heapify(int nodeIndex) {
        if (comparator != null) {
            heapifyWithComparator(nodeIndex);
        } else {
            heapifyWithoutComparator(nodeIndex);
        }
    }

    private void heapifyWithComparator(int nodeIndex) {

    }

    private void heapifyWithoutComparator(int nodeIndex) {
        /* To compare nodes with their natural ordering cast them into Comparable
         objects */
        int leftIndex = leftChild(nodeIndex);
        int rightIndex = rightChild(nodeIndex);
        Comparable<? super E> left = (Comparable<? super E>) heap[leftIndex];
        Comparable<? super E> node = (Comparable<? super E>) heap[nodeIndex];

        int largestIndex;

        if (rightIndex <= currentSize) {
            if (left.compareTo((E) heap[rightIndex]) > 0) {
                largestIndex = leftIndex;
            } else {
                largestIndex = rightIndex;
            }
            if (node.compareTo((E) heap[largestIndex]) < 0) {
                swap(nodeIndex, largestIndex);
                heapify(largestIndex);
            }
        } else if (leftIndex == currentSize && node.compareTo((E) left) < 0) {
            swap(nodeIndex, leftIndex);
        }
    }

    @Override
    public void add(E node) {
        currentSize++;
        int i = currentSize;

    }

    @Override
    public E remove() {
        if (currentSize == 0) {
            return null;
        }
        E item = (E) heap[0];

        return item;
    }

}

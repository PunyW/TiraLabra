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

    @Override
    public void heapify(int nodeIndex) {
        super.heapify(nodeIndex);
    }

    @Override
    protected void heapifyWithComparator(int nodeIndex) {

    }

    @Override
    protected void heapifyWithoutComparator(int nodeIndex) {
        if (currentSize == 1) {
            return;
        }
        /* To compare nodes with their natural ordering cast them into Comparable
         objects */
        int leftIndex;
        int rightIndex;

        if (nodeIndex == 0) {
            leftIndex = 1;
            rightIndex = 2;
        } else {
            leftIndex = getLeftChildIndex(nodeIndex);
            rightIndex = getRightChildIndex(nodeIndex);
        }

        if (leftIndex > capacity || rightIndex >= capacity) {
            return;
        }

        Comparable<? super E> left = (Comparable<? super E>) heap[leftIndex];
        Comparable<? super E> node = (Comparable<? super E>) heap[nodeIndex];

        int largestIndex;

        if (rightIndex < currentSize) {
            if (left.compareTo((E) heap[rightIndex]) > 0) {
                largestIndex = leftIndex;
            } else {
                largestIndex = rightIndex;
            }
            if (node.compareTo((E) heap[largestIndex]) < 0) {
                swap(nodeIndex, largestIndex);
                heapify(largestIndex);
            }
        } else if (leftIndex == currentSize - 1 && node.compareTo((E) left) < 0) {
            swap(nodeIndex, leftIndex);
        }
    }

    @Override
    public boolean insert(E e) {
        return super.insert(e);
    }

    @Override
    protected void insertWithoutComparator(E e) {
        Comparable<? super E> node = (Comparable<? super E>) e;

        int i = currentSize;
        currentSize++;

        while (i > 0) {
            int parentIndex = getParentIndex(i - 1);

            Object parent = heap[parentIndex];

            if (node.compareTo((E) parent) <= 0) {
                break;
            }
            heap[i] = parent;
            i = parentIndex;
        }
        heap[i] = node;
    }

    @Override
    protected void insertWithComparator(E e) {

    }

    @Override
    public E remove() {
        if (currentSize == 0) {
            return null;
        }

        E item = (E) heap[0];

        heap[0] = heap[currentSize - 1];
        heap[currentSize - 1] = null;

        currentSize--;

        heapify(0);

        return item;
    }

}

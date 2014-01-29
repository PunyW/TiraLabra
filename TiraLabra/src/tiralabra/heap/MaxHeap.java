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
        int leftIndex = getLeftChildIndex(nodeIndex);
        int rightIndex = getRightChildIndex(nodeIndex);
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

    /**
     * Insert element x into the heap, while maintaining the heap invariant by
     * going up the tree until e is greater than or equal to its parent, or it
     * is the root node.
     *
     * Same as above in the heapify comparator and non-comparator methods are
     * split.
     *
     * @param e Element to be inserted into the heap.
     * @return true if the element was inserted into the heap, otherwise false
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean insert(E e) {
        if (e == null) {
            throw new NullPointerException("Can't insert null element");
        }

        if (currentSize == capacity) {
            return false;
        }

        if (currentSize == 0) {
            heap[1] = e;
            currentSize++;
        } else {
            if (comparator == null) {
                insertWithoutComparator(e);
            } else {
//                insertWithComparator(e);
            }
        }
        return true;
    }

    private void insertWithoutComparator(E e) {
        Comparable<? super E> node = (Comparable<? super E>) e;
        currentSize++;
        int i = currentSize;

        while (i > 1) {
            int parentIndex = getParentIndex(i);
            Object parent = heap[parentIndex];

            if (node.compareTo((E) parent) < 0) {
                break;
            }
            heap[i] = parent;
            i = parentIndex;
        }
        heap[i] = node;
    }

    private void insertWithComparator(E e) {

    }

    @Override
    public E remove() {
        if (currentSize == 0) {
            return null;
        }

        E item = (E) heap[1];
        heap[1] = heap[currentSize];
        heap[currentSize] = null;

        currentSize--;

        heapify(1);

        return item;
    }

}

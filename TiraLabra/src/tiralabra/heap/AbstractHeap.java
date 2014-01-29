package tiralabra.heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Abstract heap structure for implementing heaps
 *
 * @author Joel
 * @param <E> Type of elements contained in this heap
 */
public abstract class AbstractHeap<E> implements Heap<E> {

    protected static final int DEFAULT_CAPACITY = 11;
    protected final Comparator<? super E> comparator;
    protected int currentSize;
    protected Object[] heap;
    protected int capacity;

    /**
     * Constructor for the heap.
     *
     * @param comparator custom comparator for heap
     * @param initialCapacity how many items the heap will take
     * @throws IllegalArgumentException if the initial capacity is under 1
     */
    public AbstractHeap(Comparator<? super E> comparator, int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("Initial capacity cannot be under"
                    + " 1");
        }
        this.comparator = comparator;
        this.heap = new Object[initialCapacity + 1];
        this.currentSize = 0;
        this.capacity = initialCapacity + 1;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean insert(E e) {
        if (e == null) {
            throw new NullPointerException("Can't insert null element");
        }
        if (currentSize >= capacity) {
            return false;
        }

        if (currentSize == 0) {
            heap[1] = e;
            currentSize++;
        } else {
            if (comparator == null) {
                insertWithoutComparator(e);
            } else {
                insertWithComparator(e);
            }
        }
        return true;
    }

    protected void insertWithoutComparator(E e) {

    }

    protected void insertWithComparator(E e) {

    }

    @Override
    public E remove() {
        if (currentSize == 0) {
            return null;
        }

        return (E) heap[0];
    }

    /**
     * Check that heap invariant is met at the given index.
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

    protected void heapifyWithComparator(int nodeIndex) {

    }

    protected void heapifyWithoutComparator(int nodeIndex) {

    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public void clear() {
        for (int i = 0; i < currentSize; i++) {
            heap[i] = null;
        }
        currentSize = 0;
    }

    @Override
    public boolean full() {
        return currentSize == capacity;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override
    public void printHeap() {
        System.out.println(Arrays.toString(heap));
    }

    /**
     * Returns the index of left child
     *
     * @param nodeIndex which nodes left child is being inspected
     * @return index of nodes left child
     */
    protected int getLeftChildIndex(int nodeIndex) {
        return nodeIndex * 2;
    }

    /**
     * Returns the index of right child
     *
     * @param nodeIndex which nodes right child is being inspected
     * @return index of nodes right child
     */
    protected int getRightChildIndex(int nodeIndex) {
        return nodeIndex * 2 + 1;
    }

    /**
     * Returns the index of the nodes getParentIndex
     *
     * @param nodeIndex which nodes getParentIndex is being inspected
     * @return index of the getParentIndex node
     */
    protected int getParentIndex(int nodeIndex) {
        return nodeIndex / 2;
    }

    /**
     * Swap two nodes with each other
     *
     * @param i node one to be swapped
     * @param j node two to be swapped
     */
    protected void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * Returns the index of given object, if no such object exists in the heap,
     * or the given object is null return -1
     *
     * @param o inspected object
     * @return returns the index of inspected object, otherwise -1
     */
    protected int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < currentSize; i++) {
                if (heap[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Comparator getComparator() {
        return comparator;
    }

}

package tiralabra.heap;

import java.util.Comparator;

/**
 * Abstract heap structure for implementing heaps
 *
 * @author Joel
 * @param <E> Type of elements contained in this heap
 */
public abstract class AbstractHeap<E> implements Heap<E> {

    protected static final int DEFAULT_CAPACITY = 10;
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
        this.heap = new Object[initialCapacity];
        this.currentSize = 0;
        this.capacity = initialCapacity;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean insert(E e) {
        return false;
    }

    @Override
    public E remove() {
        if (currentSize == 0) {
            return null;
        }

        return (E) heap[0];
    }

    @Override
    public void heapify(int nodeIndex) {
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

}

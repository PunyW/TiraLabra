package tiralabra.heap;

import java.util.Arrays;

/**
 * Abstract heap structure for implementing heaps
 *
 * @author Joel
 *
 * @param <E> Type of elements contained in this heap
 */
public abstract class AbstractHeap<E extends Comparable<E>> implements Heap<E> {

    protected static final int DEFAULT_CAPACITY = 10;
    protected int currentSize;
    protected Object[] heap;
    protected int capacity;

    /**
     * Constructor for the heap.
     *
     * @param initialCapacity how many items the heap will take
     * @throws IllegalArgumentException if the initial capacity is under 1
     */
    public AbstractHeap(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("Initial capacity cannot be under"
                    + " 1");
        }
        this.heap = new Object[initialCapacity];
        this.currentSize = 0;
        this.capacity = initialCapacity;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Check that heap invariant is met at the given index.
     *
     * @param nodeIndex inspected nodes index
     */
    @Override
    public void heapify(int nodeIndex) {
        /* 
         If current size is one, the only node is the root so heapify it's not
         necessary to call heapify 
         */
        if (currentSize == 1) {
            return;
        }

        heapHeapify(nodeIndex);
    }

    protected abstract void heapHeapify(int nodeIndex);

    /**
     * Insert element x into the heap, while maintaining the heap invariant by
     * going up the tree to check the nodes parent according to the heap that is
     * being implemented.
     *
     *
     * @param e Element to be inserted into the heap.
     * @return true if the element was inserted into the heap, otherwise false
     * @throws NullPointerException if the specified element is null
     * @throws NullPointerException
     */
    @Override
    public boolean insert(E e) {
        if (e == null) {
            throw new NullPointerException("Can't insert null element");
        }
        if (full()) {
            grow();
        }

        if (currentSize == 0) {
            heap[0] = e;
            currentSize++;
        } else {
            heapInsert(e);
        }
        return true;
    }

    @Override
    public boolean add(E e) {
        return insert(e);
    }

    protected abstract void heapInsert(E e);

    @Override
    public E remove() {
        if (currentSize == 0) {
            return null;
        }

        E item = (E) heap[0];

        heap[0] = heap[--currentSize ];
        heap[currentSize] = null;

        heapify(0);

        return item;
    }

    @Override
    public E pop() {
        return remove();
    }

    @Override
    public E peek() {
        if (currentSize == 0) {
            return null;
        }

        return (E) heap[0];
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
    public boolean contains(E e) {
        return indexOf(e) > -1;
    }

    @Override
    public void printHeap() {
        System.out.println(Arrays.toString(heap));
    }

    /**
     * Grow the capacity of the heap when the old capacity becomes too small. If
     * the old capacity is under 20, grow size by 10, else grow by 50%.
     */
    protected void grow() {
        int newCapacity;
        if (capacity < 20) {
            newCapacity = capacity + 10;
        } else {
            newCapacity = capacity + capacity / 2;
        }

        int maxArraySize = Integer.MAX_VALUE - 8;

        if (newCapacity > maxArraySize) {
            newCapacity = maxArraySize;
        }

        capacity = newCapacity;

        heap = Arrays.copyOf(heap, newCapacity);
    }

    /**
     * Returns the index of left child
     *
     * @param nodeIndex which nodes left child is being inspected
     * @return index of nodes left child
     */
    protected int getLeftChildIndex(int nodeIndex) {
        if (nodeIndex == 0) {
            return 1;
        }
        return nodeIndex * 2;
    }

    /**
     * Returns the index of right child
     *
     * @param nodeIndex which nodes right child is being inspected
     * @return index of nodes right child
     */
    protected int getRightChildIndex(int nodeIndex) {
        if (nodeIndex == 0) {
            return 2;
        }
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

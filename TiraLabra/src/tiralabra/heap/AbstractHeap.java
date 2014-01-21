package tiralabra.heap;

import java.util.Comparator;

/**
 *
 * @author Joel
 * @param <T> Type of elements contained in this heap
 */
public abstract class AbstractHeap<T> implements Heap<T> {

    private static final int DEFAULT_CAPACITY = 10;
    protected final Comparator<? super T> comparator;
    protected int currentSize;
    protected Object[] heap;

    public AbstractHeap() {
        this(null, DEFAULT_CAPACITY);
    }

    public AbstractHeap(Comparator<? super T> comparator, int initialCapacity) {
        this.comparator = comparator;
        this.heap = new Object[initialCapacity];
        this.currentSize = 0;
    }

    public AbstractHeap(int capacity) {
        this(null, capacity);
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public void add(T e) {
    }

    @Override
    public T remove() {
        if(currentSize == 0) {
            return null;
        }
        return (T) heap[0];
    }

    @Override
    public void heapify(int index) {
    }
    
    @Override
    public int size() {
        return currentSize;
    }

}

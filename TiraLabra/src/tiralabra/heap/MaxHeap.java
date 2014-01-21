package tiralabra.heap;

import java.util.Comparator;

/**
 *
 * @author Joel
 * @param <T> Type of elements held in this heap
 */
public class MaxHeap<T> extends AbstractHeap<T> {

    @Override
    public void heapify(int index) {

    }

    @Override
    public void add(T node) {
        ++currentSize;
        int i = currentSize;

    }

    @Override
    public T remove() {
        if (currentSize == 0) {
            return null;
        }
        T item = (T) heap[0];

        return item;
    }

}

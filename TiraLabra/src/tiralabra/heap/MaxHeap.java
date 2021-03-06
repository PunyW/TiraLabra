package tiralabra.heap;

/**
 *
 * @author Joel
 * @param <E> Type of elements held in this heap
 */
public class MaxHeap<E extends Comparable<E>> extends AbstractHeap<E> {

    /**
     * Constructor for max heap that uses elements natural ordering for the
     * comparison and assigns heap capacity into DEFAULT_CAPACITY
     */
    public MaxHeap() {
        super(DEFAULT_CAPACITY);
    }

    /**
     * Constructor for max heap that uses elements natural ordering for the
     * comparison and heaps capacity is the given custom value
     *
     * @param capacity how many items the heap will take
     */
    public MaxHeap(int capacity) {
        super(capacity);
    }

    @Override
    protected void heapHeapify(int nodeIndex) {

        int leftIndex = getLeftChildIndex(nodeIndex);
        int rightIndex = getRightChildIndex(nodeIndex);

        if (rightIndex >= capacity) {
            return;
        }

        /* 
         To compare nodes with their natural ordering cast them into Comparable
         objects 
         */
        E left = (E) heap[leftIndex];
        E node = (E) heap[nodeIndex];

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
    protected void heapInsert(E node) {
        int i = currentSize++;

        while (i > 0) {
            int parentIndex = getParentIndex(i - 1);

            E parent = (E) heap[parentIndex];

            if (node.compareTo(parent) <= 0) {
                break;
            }
            heap[i] = parent;
            i = parentIndex;
        }
        heap[i] = node;
    }

}

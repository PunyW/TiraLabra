package tiralabra.heap;

/**
 *
 * @author Joel
 * @param <E> Type of elements contained within the heap
 */
public class MinHeap<E extends Comparable<E>> extends AbstractHeap<E> {

    public MinHeap(int initialCapacity) {
        super(initialCapacity);
    }

    public MinHeap() {
        super(DEFAULT_CAPACITY);
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
        Comparable<? super E> left = (Comparable<? super E>) heap[leftIndex];
        Comparable<? super E> node = (Comparable<? super E>) heap[nodeIndex];

        int largestIndex;

        if (rightIndex < currentSize) {
            if (left.compareTo((E) heap[rightIndex]) < 0) {
                largestIndex = leftIndex;
            } else {
                largestIndex = rightIndex;
            }
            if (node.compareTo((E) heap[largestIndex]) > 0) {
                swap(nodeIndex, largestIndex);
                heapify(largestIndex);
            }
        } else if (leftIndex == currentSize - 1 && node.compareTo((E) left) > 0) {
            swap(nodeIndex, leftIndex);
        }
    }

    @Override
    protected void heapInsert(E e) {
        Comparable<? super E> node = (Comparable<? super E>) e;

        int i = currentSize;
        currentSize++;

        while (i > 0) {
            int parentIndex = getParentIndex(i - 1);

            Object parent = heap[parentIndex];

            if (node.compareTo((E) parent) >= 0) {
                break;
            }
            heap[i] = parent;
            i = parentIndex;
        }
        heap[i] = node;
    }

}

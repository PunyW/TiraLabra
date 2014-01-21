package tiralabra.algorithms;

/**
 *
 * @author Joel
 */
public class HeapSort {

    private int heapSize;

    /**
     * Sort an list using heap sort
     *
     * @param list list to be sorted
     */
    public void sort(int[] list) {
        buildHeap(list);
        for (int i = heapSize; i > 0; i--) {
            swap(list, 0, i);
            --heapSize;
            heapify(list, 0);
        }
    }

    /**
     * Change the array so it becomes a heap-like data structure.
     *
     * @param A list to be modified
     */
    private void buildHeap(int[] A) {
        heapSize = A.length - 1;
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(A, i);
        }
    }

    /**
     * Check that the heap conditions are met at the given index of the array.
     * <p>
     * If either of the nodes children are larger than the node itself, swap the
     * larger children and the nodes position. And recursively call heapify at
     * the larger child's position. If there is only left child which is larger
     * than the node itself swap them.
     *
     *
     *
     * @param A Array
     * @param index index of the node to be inspected
     */
    private void heapify(int[] A, int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int largest;

        if (right <= heapSize) {
            if (A[left] > A[right]) {
                largest = left;
            } else {
                largest = right;
            }
            if (A[index] < A[largest]) {
                swap(A, index, largest);
                heapify(A, largest);
            }
        } else if (left == A.length && A[index] < A[left]) {
            swap(A, index, left);
        }
    }

    /**
     * Swap two nodes in the list with each other.
     *
     * @param A list
     * @param i first node to be swapped
     * @param k second node to be swapped
     */
    private void swap(int[] A, int i, int k) {
        int temp = A[i];
        A[i] = A[k];
        A[k] = temp;
    }

    /**
     * Get the index of nodes left child
     *
     * @param index nodes index
     * @return index of the nodes left child
     */
    private int leftChild(int index) {
        return index * 2;
    }

    /**
     * Get the index of nodes right child
     *
     * @param index nodes index
     * @return index of the nodes right child
     */
    private int rightChild(int index) {
        return index * 2 + 1;
    }

}

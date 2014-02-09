package tiralabra.algorithms;

/**
 *
 * @author Joel
 */
public class HeapSort {

    private static int heapSize;

    /**
     * Sort an list using heap sort.
     * <p>
     * First make the list into a heap by calling build heap, which calls
     * heapify to each node with a child. After which the list is presented as a
     * max heap like data structure, and now we know that the largest node is at
     * position 0. To sort the array we swap the first and last items place, so
     * now the largest item is the very last of the array, to exclude the
     * largest item from further heapify operations decrease heap size by 1.
     * </p>
     *
     *
     * @param list list to be sorted
     */
    public static void sort(int[] list) {
        heapSize = list.length - 1;
        buildHeap(list);
        for (int i = heapSize; i > 0; i--) {
            swap(list, 0, i);
            heapSize--;
            heapify(list, 0);
        }
    }

    /**
     * Change the array so it becomes a heap-like data structure.
     *
     * @param A list to be modified
     */
    private static void buildHeap(int[] A) {
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
     * </p>
     *
     *
     * @param A Array
     * @param index index of the node to be inspected
     */
    private static void heapify(int[] A, int index) {
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
        }
    }

    /**
     * Swap two nodes in the list with each other.
     *
     * @param A list
     * @param i first node to be swapped
     * @param k second node to be swapped
     */
    private static void swap(int[] A, int i, int k) {
        int temp = A[i];
        A[i] = A[k];
        A[k] = temp;
    }

    /**
     * Get the index of nodes left child
     *
     * @param nodeIndex nodes index
     * @return index of the nodes left child
     */
    private static int leftChild(int nodeIndex) {
        return nodeIndex * 2;
    }

    /**
     * Get the index of nodes right child
     *
     * @param nodeIndex nodes index
     * @return index of the nodes right child
     */
    private static int rightChild(int nodeIndex) {
        return nodeIndex * 2 + 1;
    }

}

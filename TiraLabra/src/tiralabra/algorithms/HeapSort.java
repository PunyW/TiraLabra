package tiralabra.algorithms;

/**
 *
 * @author Joel
 */
public class HeapSort {

    private int heapSize;

    public void sort(int[] list) {
        buildHeap(list);
        for (int i = heapSize; i > 0; i--) {
            swap(list, 0, i);
            --heapSize;
            heapify(list, 0);
        }
    }

    private void buildHeap(int[] A) {
        heapSize = A.length - 1;
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(A, i);
        }
    }

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

    private void swap(int[] A, int i, int k) {
        int temp = A[i];
        A[i] = A[k];
        A[k] = temp;
    }

    private int leftChild(int index) {
        return index * 2;
    }

    private int rightChild(int index) {
        return index * 2 + 1;
    }

}

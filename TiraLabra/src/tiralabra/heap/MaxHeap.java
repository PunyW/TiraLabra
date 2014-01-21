package tiralabra.heap;

/**
 *
 * @author Joel
 */
public class MaxHeap extends AbstractHeap {

    @Override
    public void heapify(int index) {

    }

    @Override
    public void add(Node node) {
        ++currentSize;
        int i = currentSize;
        while(i > 0 && parent(i).getValue() < node.getValue()) {
            
        }
    }

}

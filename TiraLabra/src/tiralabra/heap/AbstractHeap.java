package tiralabra.heap;

/**
 *
 * @author Joel
 */
public abstract class AbstractHeap implements Heap {

    protected int currentSize;
    protected Node[] nodes;

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public void add(Node node) {
    }

    @Override
    public Node remove() {
        return nodes[0];
    }

    @Override
    public void heapify(int index) {
    }

    @Override
    public Node parent(int index) {
        return nodes[index / 2];
    }

    @Override
    public Node left(int index) {
        int childIndex = index * 2;
        if (currentSize >= childIndex) {
            return nodes[childIndex];
        } else {
            return null;
        }
    }

    @Override
    public Node right(int index) {
        int childIndex = index * 2 + 1;
        if (currentSize >= childIndex) {
            return nodes[childIndex];
        } else {
            return null;
        }
    }

}

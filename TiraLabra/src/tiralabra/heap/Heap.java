package tiralabra.heap;

/**
 * Interface for heap data structures, that provides fast access to the first
 * element of the heap.
 *
 * @author Joel
 *
 */
public interface Heap {

    /**
     * Check if the heap is empty.
     *
     * @return Returns true if the heap is empty, otherwise false
     */
    public boolean isEmpty();

    /**
     * Add an item to the heap. Override this method in heap implementation.
     *
     * @param node Node to be inserted
     */
    public void add(Node node);

    /**
     * Remove the first item of the heap, in max-heap the item with maximum
     * value and in min-heap the item with the minimum value.
     *
     * @return First item of the heap
     */
    public Node remove();

    /**
     * Check that the heap conditions are met at the index node, if they aren't
     * fix it. Override this method in heap implementation.
     *
     * @param index The node which heap condition is to be inspected
     */
    public void heapify(int index);

    /**
     * Get the parent of the node.
     *
     * @param index Which nodes parent
     * @return Returns the parent of the given node
     */
    public Node parent(int index);

    /**
     * Get the left child of the node, returns null if the node has no left
     * child.
     *
     * @param index Which nodes left child
     * @return Returns null if the node has no left child, otherwise returns the
     * left child
     */
    public Node left(int index);

    /**
     * Get the right child of the node, returns null if the node has no right
     * child.
     *
     * @param index Which nodes right child
     * @return Returns null if the node has no right child, otherwise returns
     * the right child
     */
    public Node right(int index);
    

}

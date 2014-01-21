package tiralabra.heap;

/**
 * Interface for heap data structures, that provides fast access to the first
 * element of the heap.
 *
 * @author Joel
 * @param <T> Type of elements contained in this heap
 *
 */
public interface Heap<T> {

    /**
     * Check if the heap is empty.
     *
     * @return Returns true if the heap is empty, otherwise false
     */
    public boolean isEmpty();

    /**
     * Add an item to the heap. Override this method in heap implementation.
     *
     * @param e E to be inserted
     */
    public void add(T e);

    /**
     * Remove the first item of the heap, in max-heap the item with maximum
     * value and in min-heap the item with the minimum value.
     *
     * @return First item of the heap
     */
    public T remove();

    /**
     * Check that the heap conditions are met at the index node, if they aren't
     * fix it. Override this method in heap implementation.
     *
     * @param index The node which heap condition is to be inspected
     */
    public void heapify(int index);
    
    /**
     * 
     * @return how many elements there is currently in the heap 
     */
    public int size();

    /**
     * Removes all the objects from this heap, the heap will be empty after this
     * call
     */
    public void clear();

}

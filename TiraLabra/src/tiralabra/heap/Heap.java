package tiralabra.heap;

import java.util.Comparator;

/**
 * Interface for heap data structures, that provides fast access to the first
 * element of the heap.
 *
 * @author Joel
 * @param <E> Type of elements contained in this heap
 *
 */
public interface Heap<E> {

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
     * @return true if the element was inserted into the heap
     */
    public boolean insert(E e);

    /**
     * Add an item to the heap. Override this method in heap implementation.
     *
     * @param e E to be inserted
     * @return true if the element was inserted into the heap
     */
    public boolean add(E e);

    /**
     * Remove the first item of the heap, in max-heap the item with maximum
     * value and in min-heap the item with the minimum value.
     *
     * @return First item of the heap
     */
    public E remove();

    /**
     * Remove the first item of the heap, in max-heap the item with maximum
     * value and in min-heap the item with the minimum value.
     *
     * @return First item of the heap
     */
    public E pop();

    /**
     * Peek at the first item of the heap without removing it
     *
     * @return First item of the heap
     */
    public E peek();

    /**
     * Check that the heap conditions are met at the index node, if they aren't
     * fix it. Override this method in heap implementation.
     *
     * @param nodeIndex The node which heap condition is to be inspected
     */
    public void heapify(int nodeIndex);

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

    /**
     * Check if the heap is full.
     *
     * @return true if the heap is full, otherwise false.
     */
    public boolean full();

    /**
     * Check if given element is contained in the heap.
     *
     * @param e inspected element
     * @return true if the inspected element is contained within the heap,
     * otherwise returns false
     */
    public boolean contains(E e);

    public void printHeap();
}

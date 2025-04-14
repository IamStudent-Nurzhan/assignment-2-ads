/**
 * Implementation of a minimum heap using MyArrayList.
 * @param <T> The type of data stored in the heap.
 */
public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list; // The underlying list to store elements

    /**
     * Constructs an empty MyMinHeap.
     */
    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    /**
     * Inserts an element into the heap.
     * @param element The element to insert.
     */
    public void insert(T element) {
        list.add(element);
        heapifyUp(list.size() - 1);
    }

    /**
     * Extracts the minimum element from the heap.
     * @return The minimum element.
     */
    public T extractMin() {
        if (list.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        heapifyDown(0);
        return min;
    }

    /**
     * Peeks at the minimum element without removing it.
     * @return The minimum element.
     */
    public T peekMin() {
        if (list.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return list.get(0);
    }

    /**
     * Returns the size of the heap.
     * @return The size of the heap.
     */
    public int size() {
        return list.size();
    }

    /**
     * Moves the element at the specified index up the heap to maintain the heap property.
     * @param index The index of the element to move up.
     */
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && list.get(index).compareTo(list.get(parent)) < 0) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    /**
     * Moves the element at the specified index down the heap to maintain the heap property.
     * @param index The index of the element to move down.
     */
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < list.size() && list.get(leftChild).compareTo(list.get(smallest)) < 0) {
            smallest = leftChild;
        }
        if (rightChild < list.size() && list.get(rightChild).compareTo(list.get(smallest)) < 0) {
            smallest = rightChild;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    /**
     * Swaps the elements at the specified indices.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}

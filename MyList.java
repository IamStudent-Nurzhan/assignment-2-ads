/**
 * Interface MyList, which extends Iterable and defines methods for working with a list.
 * @param <T> The type of data stored in the list.
 */
public interface MyList<T> extends Iterable<T> {
    /**
     * Adds an element to the end of the list.
     * @param item The element to add.
     */
    void add(T item);

    /**
     * Sets an element at the specified index.
     * @param index The index of the element.
     * @param item The element to set.
     */
    void set(int index, T item);

    /**
     * Adds an element to the list at the specified index.
     * @param index The index to add the element at.
     * @param item The element to add.
     */
    void add(int index, T item);

    /**
     * Adds an element to the beginning of the list.
     * @param item The element to add.
     */
    void addFirst(T item);

    /**
     * Adds an element to the end of the list.
     * @param item The element to add.
     */
    void addLast(T item);

    /**
     * Returns the element at the specified index.
     * @param index The index of the element.
     * @return The element at the specified index.
     */
    T get(int index);

    /**
     * Returns the first element in the list.
     * @return The first element in the list.
     */
    T getFirst();

    /**
     * Returns the last element in the list.
     * @return The last element in the list.
     */
    T getLast();

    /**
     * Removes the element at the specified index.
     * @param index The index of the element to remove.
     */
    void remove(int index);

    /**
     * Removes the first element in the list.
     */
    void removeFirst();

    /**
     * Removes the last element in the list.
     */
    void removeLast();

    /**
     * Sorts the list.
     */
    void sort();

    /**
     * Returns the index of the first occurrence of the specified element.
     * @param object The element to find.
     * @return The index of the first occurrence of the element, or -1 if not found.
     */
    int indexOf(Object object);

    /**
     * Returns the index of the last occurrence of the specified element.
     * @param object The element to find.
     * @return The index of the last occurrence of the element, or -1 if not found.
     */
    int lastIndexOf(Object object);

    /**
     * Checks if the list contains the specified element.
     * @param object The element to check.
     * @return True if the element exists in the list, false otherwise.
     */
    boolean exists(Object object);

    /**
     * Converts the list to an array.
     * @return An array containing all elements of the list.
     */
    Object[] toArray();

    /**
     * Clears the list.
     */
    void clear();

    /**
     * Returns the size of the list.
     * @return The size of the list.
     */
    int size();
}

import java.util.Iterator;

/**
 * Implementation of a dynamic array-based list.
 * @param <T> The type of data stored in the list.
 */
public class MyArrayList<T> implements MyList<T> {
    private Object[] elements; // Array to store elements
    private int length; // Current size of the list

    /**
     * Constructs an empty MyArrayList with an initial capacity of 5.
     */
    public MyArrayList() {
        elements = new Object[5];
        length = 0;
    }

    /**
     * Adds an element to the end of the list.
     * @param item The element to add.
     */
    @Override
    public void add(T item) {
        if (length == elements.length) {
            increaseCapacity();
        }
        elements[length++] = item;
    }

    /**
     * Sets an element at the specified index.
     * @param index The index of the element.
     * @param item The element to set.
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    /**
     * Adds an element to the list at the specified index.
     * @param index The index to add the element at.
     * @param item The element to add.
     */
    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        if (length == elements.length) {
            increaseCapacity();
        }
        System.arraycopy(elements, index, elements, index + 1, length - index);
        elements[index] = item;
        length++;
    }

    /**
     * Adds an element to the beginning of the list.
     * @param item The element to add.
     */
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * Adds an element to the end of the list.
     * @param item The element to add.
     */
    @Override
    public void addLast(T item) {
        add(item);
    }

    /**
     * Returns the element at the specified index.
     * @param index The index of the element.
     * @return The element at the specified index.
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Returns the first element in the list.
     * @return The first element in the list.
     */
    @Override
    public T getFirst() {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        return get(0);
    }

    /**
     * Returns the last element in the list.
     * @return The last element in the list.
     */
    @Override
    public T getLast() {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        return get(length - 1);
    }

    /**
     * Removes the element at the specified index.
     * @param index The index of the element to remove.
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, length - index - 1);
        elements[--length] = null;
    }

    /**
     * Removes the first element in the list.
     */
    @Override
    public void removeFirst() {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        remove(0);
    }

    /**
     * Removes the last element in the list.
     */
    @Override
    public void removeLast() {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        remove(length - 1);
    }

    /**
     * Sorts the list.
     */
    @Override
    public void sort() {
        java.util.Arrays.sort((T[]) elements, 0, length);
    }

    /**
     * Returns the index of the first occurrence of the specified element.
     * @param object The element to find.
     * @return The index of the first occurrence of the element, or -1 if not found.
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element.
     * @param object The element to find.
     * @return The index of the last occurrence of the element, or -1 if not found.
     */
    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if the list contains the specified element.
     * @param object The element to check.
     * @return True if the element exists in the list, false otherwise.
     */
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    /**
     * Converts the list to an array.
     * @return An array containing all elements of the list.
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        System.arraycopy(elements, 0, array, 0, length);
        return array;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            elements[i] = null;
        }
        length = 0;
    }

    /**
     * Returns the size of the list.
     * @return The size of the list.
     */
    @Override
    public int size() {
        return length;
    }

    /**
     * Returns an iterator for the list.
     * @return An iterator for the list.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                return (T) elements[currentIndex++];
            }
        };
    }

    /**
     * Increases the capacity of the internal array.
     */
    private void increaseCapacity() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    /**
     * Checks if the index is valid for getting an element.
     * @param index The index to check.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }

    /**
     * Checks if the index is valid for adding an element.
     * @param index The index to check.
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }
}

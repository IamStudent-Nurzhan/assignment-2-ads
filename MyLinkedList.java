import java.util.Iterator;

/**
 * Implementation of a doubly linked list.
 * @param <T> The type of data stored in the list.
 */
public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head; // The first node in the list
    private MyNode<T> tail; // The last node in the list
    private int length; // Current size of the list

    /**
     * Represents a node in the linked list.
     * @param <T> The type of data stored in the node.
     */
    private static class MyNode<T> {
        T data; // The data stored in the node
        MyNode<T> next; // The next node in the list
        MyNode<T> prev; // The previous node in the list

        /**
         * Constructs a new node with the specified data.
         * @param data The data to store in the node.
         */
        MyNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Constructs an empty MyLinkedList.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * Adds an element to the end of the list.
     * @param item The element to add.
     */
    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    /**
     * Sets an element at the specified index.
     * @param index The index of the element.
     * @param item The element to set.
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        MyNode<T> current = getNode(index);
        current.data = item;
    }

    /**
     * Adds an element to the list at the specified index.
     * @param index The index to add the element at.
     * @param item The element to add.
     */
    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        MyNode<T> newNode = new MyNode<>(item);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == length) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            MyNode<T> current = getNode(index);
            newNode.next = current;
            newNode.prev = current.prev;
            if (current.prev != null) {
                current.prev.next = newNode;
            }
            current.prev = newNode;
        }
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
        return getNode(index).data;
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
        return head.data;
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
        return tail.data;
    }

    /**
     * Removes the element at the specified index.
     * @param index The index of the element to remove.
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode<T> current = getNode(index);
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        length--;
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
        // Implement sorting logic if needed
    }

    /**
     * Returns the index of the first occurrence of the specified element.
     * @param object The element to find.
     * @return The index of the first occurrence of the element, or -1 if not found.
     */
    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode<T> current = head; current != null; current = current.next) {
            if (current.data.equals(object)) {
                return index;
            }
            index++;
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
        int index = length - 1;
        for (MyNode<T> current = tail; current != null; current = current.prev) {
            if (current.data.equals(object)) {
                return index;
            }
            index--;
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
        int index = 0;
        for (MyNode<T> current = head; current != null; current = current.next) {
            array[index++] = current.data;
        }
        return array;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
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
            private MyNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Returns the node at the specified index.
     * @param index The index of the node.
     * @return The node at the specified index.
     */
    private MyNode<T> getNode(int index) {
        if (index < length / 2) {
            MyNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            MyNode<T> current = tail;
            for (int i = length - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
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


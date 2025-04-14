/**
 * Implementation of a stack using MyArrayList.
 * @param <T> The type of data stored in the stack.
 */
public class MyStack<T> {
    private MyArrayList<T> list; // The underlying list to store elements

    /**
     * Constructs an empty MyStack.
     */
    public MyStack() {
        list = new MyArrayList<>();
    }

    /**
     * Pushes an element onto the stack.
     * @param element The element to push.
     */
    public void push(T element) {
        list.add(element);
    }

    /**
     * Pops an element from the stack.
     * @return The element popped from the stack.
     */
    public T pop() {
        if (list.size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return element;
    }

    /**
     * Peeks at the top element of the stack without removing it.
     * @return The top element of the stack.
     */
    public T peek() {
        if (list.size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    /**
     * Returns the size of the stack.
     * @return The size of the stack.
     */
    public int size() {
        return list.size();
    }
}

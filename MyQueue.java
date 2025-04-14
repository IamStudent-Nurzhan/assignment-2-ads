/**
 * Implementation of a queue using MyLinkedList.
 * @param <T> The type of data stored in the queue.
 */
public class MyQueue<T> {
    private MyLinkedList<T> list; // The underlying list to store elements

    /**
     * Constructs an empty MyQueue.
     */
    public MyQueue() {
        list = new MyLinkedList<>();
    }

    /**
     * Enqueues an element into the queue.
     * @param element The element to enqueue.
     */
    public void enqueue(T element) {
        list.add(element);
    }

    /**
     * Dequeues an element from the queue.
     * @return The element dequeued from the queue.
     */
    public T dequeue() {
        if (list.size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = list.getFirst();
        list.removeFirst();
        return element;
    }

    /**
     * Peeks at the front element of the queue without removing it.
     * @return The front element of the queue.
     */
    public T peek() {
        if (list.size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    /**
     * Returns the size of the queue.
     * @return The size of the queue.
     */
    public int size() {
        return list.size();
    }
}

/**
 * Main class to test the implementations of MyArrayList, MyLinkedList, MyStack, MyQueue, and MyMinHeap.
 */
public class Main {
    public static void main(String[] args) {
        // Test MyArrayList
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        print(arrayList);

        // Test MyLinkedList
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        print(linkedList);

        // Test MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack Pop: " + stack.pop());
        System.out.println("Stack Peek: " + stack.peek());
        System.out.println("Stack Size: " + stack.size());

        // Test MyQueue
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue Dequeue: " + queue.dequeue());
        System.out.println("Queue Peek: " + queue.peek());
        System.out.println("Queue Size: " + queue.size());

        // Test MyMinHeap
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        System.out.println("MinHeap ExtractMin: " + minHeap.extractMin());
        System.out.println("MinHeap PeekMin: " + minHeap.peekMin());
        System.out.println("MinHeap Size: " + minHeap.size());
    }

    /**
     * Prints the elements of the list.
     * @param list The list to print.
     */
    public static void print(MyList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}

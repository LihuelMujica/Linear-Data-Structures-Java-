package queues;

import java.util.LinkedList;

public class LinkedListQueue {
    LinkedList<Integer> items;


    public void enqueue(int value) {
        items.addLast(value);
    }

    public int dequeue() {
        if(isEmpty())
            throw new IllegalStateException();

        return items.removeFirst();
    }

    public int peek() {
        if(isEmpty())
            throw new IllegalStateException();

        return items.peekFirst();
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public LinkedListQueue() {
        items = new LinkedList<>();
    }
}

package queues.priorityqueues;

import java.util.Arrays;

public class PriorityQueue {
    int[] items;
    int count = 0;

    public void enqueue(int item) {
        if(isFull())
            throw new IllegalStateException();

        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item) items[i + 1] = items[i];
            else {
                break;
            }
        }

        items[i + 1] = item;
        count++;
    }

    public boolean isFull() {
        return items.length == count;
    }

    public int dequeue() {
       if (count == 0)
           throw new IllegalStateException();

       return items[--count];
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public PriorityQueue(int length) {
        items = new int[length];
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}

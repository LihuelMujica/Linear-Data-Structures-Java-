package queues;

public class ArrayQueue {
    int[] items;
    int front;
    int rear;
    int count;

    public void enqueue(int value) throws Exception {
        if(isFull() && !isEmpty()) throw new Exception("queue over flow");


        items[rear++] = value;
        count++;
        if(rear>4) rear = 0;
    }

    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException();

        int output = items[front++];
        count--;
        if (front>4) front=0;
        return output;
    }

    public int peek() {
        return items[front];
    }

    public boolean isFull() {
        return count==5;
    }

    public boolean isEmpty() {
        return count == 0;
    }


    public ArrayQueue(int size) {
        items = new int[size];
        front = 0;
        rear = 0;
        count = 0;
    }
}

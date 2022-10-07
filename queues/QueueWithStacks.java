package queues;

import java.util.Stack;

public class QueueWithStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int value) {
        stack1.push(value);
    }

    public int dequeue() {
        if(isEmpty())
            throw new IllegalStateException();
        moveStack1ToStack2();
        return stack2.pop();
    }

    private void moveStack1ToStack2() {
        if(stack2.isEmpty()) fullfil();
    }

    private void fullfil() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int peek() {
        moveStack1ToStack2();
        return stack2.peek();
    }

    public boolean isEmpty(){
        return stack2.isEmpty() && stack1.isEmpty();
    }



}

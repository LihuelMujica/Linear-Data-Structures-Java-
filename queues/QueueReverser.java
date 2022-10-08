package queues;

import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public void reverser(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }

        while(!stack.isEmpty())
            queue.add(stack.pop());

        for (int i = 0; i < queue.size()-k ; i++) {
            queue.add(queue.remove());
        }
    }
}

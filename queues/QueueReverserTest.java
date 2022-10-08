package queues;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueReverserTest {

    @Test
    public void test() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        QueueReverser queueReverser = new QueueReverser();

        queueReverser.reverser(queue,3);

        assertEquals(30,queue.remove());
        assertEquals(20,queue.remove());
        assertEquals(10,queue.remove());
        assertEquals(40,queue.remove());
        assertEquals(50,queue.remove());
    }
}
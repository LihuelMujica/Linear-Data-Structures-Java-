package queues;

import org.junit.jupiter.api.Test;
import stacks.ArrayStack;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest {

    @Test
    public void test() {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(10);
        assertEquals(10, queue.dequeue());

        assertThrows(IllegalStateException.class, queue::dequeue);

        assertTrue(queue.isEmpty());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.peek());

        queue.enqueue(40);
        queue.enqueue(50);

        assertFalse(queue.isEmpty());

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
        assertEquals(40, queue.dequeue());
        assertEquals(50, queue.dequeue());
        assertTrue(queue.isEmpty());
        assertThrows(IllegalStateException.class, queue::dequeue);

    }

}
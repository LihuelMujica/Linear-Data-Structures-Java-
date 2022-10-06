package queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    @Test
    public void test() throws Exception {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        assertEquals(10, queue.dequeue());

        assertThrows(IllegalStateException.class, queue::dequeue);

        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.peek());

        queue.enqueue(40);
        queue.enqueue(50);

        assertTrue(queue.isFull());
        assertFalse(queue.isEmpty());

        assertThrows(Exception.class, () -> queue.enqueue(4));
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
        assertEquals(40, queue.dequeue());
        assertEquals(50, queue.dequeue());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        assertThrows(IllegalStateException.class, queue::dequeue);

    }

}
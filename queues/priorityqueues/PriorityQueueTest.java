package queues.priorityqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    public void test() {
        PriorityQueue queue = new PriorityQueue(5);

        assertThrows(IllegalStateException.class, queue::dequeue);
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(10);
        queue.enqueue(30);
        queue.enqueue(4);


        assertEquals(30, queue.dequeue());
        assertEquals(10, queue.dequeue());
        assertEquals(4, queue.dequeue());

        queue.enqueue(1);
        queue.enqueue(10);
        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(2);

        assertTrue(queue.isFull());
        assertFalse(queue.isEmpty());

        assertThrows(IllegalStateException.class, () -> queue.enqueue(4));

        assertEquals(10, queue.dequeue());
        assertEquals(8, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.dequeue());


    }

}
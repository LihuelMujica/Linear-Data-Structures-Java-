package stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayStackTest {

    @Test
    public void test() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push(10);
        assertEquals("[10]",arrayStack.toString());
        arrayStack.push(20);
        assertEquals("[10, 20]",arrayStack.toString());
        arrayStack.push(30);
        assertEquals("[10, 20, 30]",arrayStack.toString());
        assertEquals(30, arrayStack.pop());
        assertEquals(20, arrayStack.peek());
        assertEquals("[10, 20]",arrayStack.toString());
        assertEquals(20, arrayStack.pop());
        assertEquals(10, arrayStack.pop());
        assertTrue(arrayStack.isEmpty());
    }

}
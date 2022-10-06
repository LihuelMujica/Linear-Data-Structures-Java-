package stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoStacksOneArrayTest {

    @Test
    public void test() {
        TwoStacksOneArray stack = new TwoStacksOneArray();
        assertTrue(stack.isEmpty1());
        assertTrue(stack.isEmpty2());
        assertFalse(stack.isFull1());
        assertFalse(stack.isFull2());
        stack.push1(10);
        assertEquals(10,stack.pop1());
        assertThrows(IllegalStateException.class, stack::pop2);
        assertFalse(stack.isFull1());
        assertFalse(stack.isFull2());
        stack.push1(10);
        stack.push2(10);
        assertEquals(10, stack.pop2());
        stack.push2(10);
        stack.push1(20);
        stack.push2(20);
        assertFalse(stack.isFull1());
        assertFalse(stack.isFull2());
        stack.push2(30);
        assertTrue(stack.isFull1());
        assertTrue(stack.isFull2());
        assertFalse(stack.isEmpty1());
        assertFalse(stack.isEmpty2());
        assertThrows(StackOverflowError.class, () -> stack.push1(30));
        assertThrows(StackOverflowError.class, () -> stack.push2(30));

    }


}
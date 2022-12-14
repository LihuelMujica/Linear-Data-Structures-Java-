package linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList list;

    @BeforeEach
    public void before() {
        list = new LinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
    }

    @Test
    public void test(){
        assertEquals("[30,20,10]",list.toString());
        assertEquals(3,list.size());
        list.addLast(40);
        assertEquals("[30,20,10,40]",list.toString());
        list.reverse();
        assertEquals("[40,10,20,30]",list.toString());
        list.reverse();
        assertEquals(4,list.size());
        list.deleteFirst();
        assertEquals("[20,10,40]",list.toString());
        assertEquals(3,list.size());
        list.deleteLast();
        assertEquals("[20,10]",list.toString());
        assertEquals(2,list.size());
        assertTrue(list.contains(10));
        assertFalse(list.contains(40));
        assertEquals(1, list.indexOf(10));
        assertEquals("[20, 10]", Arrays.toString(list.toArray()));
    }

    @Test
    public void getKthFromTheEnd(){ //[30,20,10]
        assertEquals(10,list.getKthFromTheEnd(1));
        assertEquals(20, list.getKthFromTheEnd(2));
        assertEquals(30, list.getKthFromTheEnd(3));
        list.deleteLast();
        assertEquals(20,list.getKthFromTheEnd(1));
        assertEquals(30, list.getKthFromTheEnd(2));
        list.deleteLast();
        assertEquals(30, list.getKthFromTheEnd(1));
        assertThrows(IllegalArgumentException.class,() -> list.getKthFromTheEnd(2));
    }

    @Test
    public void hasLoop() {
        assertFalse(list.hasLoop());
        list.circleList();
        assertTrue(list.hasLoop());
    }
}
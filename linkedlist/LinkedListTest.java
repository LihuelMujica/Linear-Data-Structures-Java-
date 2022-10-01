package linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        list.addLast(40);
        assertEquals("[30,20,10,40]",list.toString());
        list.deleteFirst();
        assertEquals("[20,10,40]",list.toString());
        list.deleteLast();
        assertEquals("[20,10]",list.toString());
        assertEquals(true,list.contains(10));
        assertEquals(false, list.contains(40));
        assertEquals(1, list.indexOf(10));
    }
}
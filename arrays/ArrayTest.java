package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    Array array;

    @BeforeEach
    public void before() {
        array = new Array(3);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
    }

    @Test
    public void test(){
        array.removeAt(3);
        assertEquals(0,array.indexOf(10));
        assertEquals("[10,20,30]",array.toString());
    }

    @Test
    public void ex() {
        var array2 = new Array(2);
        array2.insert(10);
        array2.insert(40);
        assertEquals(40,array.max());
        assertEquals("[10,40]",array.intersect(array2).toString());
        array.reverse();
        assertEquals("[40,30,20,10]",array.toString());
        array.reverse();
        array.insertAt(25,2);
        assertEquals("[10,20,25,30,40]",array.toString());
    }

}
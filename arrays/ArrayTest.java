package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    Array array;

    @BeforeEach
    public void before() {
        Array numbers = new Array(3);
    }

    @Test
    public void test(){
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.removeAt(3);
        assertEquals(0,array.indexOf(10));
        assertEquals("[10,20,30]",array.toString());
    }

}
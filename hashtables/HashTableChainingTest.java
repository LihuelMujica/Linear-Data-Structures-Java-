package hashtables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableChainingTest {
    @Test
    public void test(){
        assertThrows(IllegalArgumentException.class, () -> new HashTableChaining(-1));
        HashTableChaining map = new HashTableChaining(4);
        assertNull(map.get(40));
        map.put(40,"Hola");
        assertEquals("Hola",map.get(40));
        map.put(1000,"asfoawg");
        assertEquals("asfoawg", map.get(1000));
        map.put(30,"30");
        assertEquals("30", map.get(30));
        map.put(40,"40");
        assertEquals("40",map.get(40));
        assertThrows(IllegalStateException.class, () -> map.remove(90));
        map.remove(40);
        assertNull(map.get(40));
    }
}
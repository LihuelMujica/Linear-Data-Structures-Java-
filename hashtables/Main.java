package hashtables;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Key: Employee Number (Integer)
        // Value: Name (String)
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Roberto");
        map.put(2, "Federico");
        map.put(3, "María");
        map.put(3, "Marianne");
        map.put(4, null);
        map.put(null, null);
        map.remove(null);
        var value = map.get(3);
        map.containsKey(3); //O(1)
        map.containsValue("Roberto"); // O(n)
        System.out.println(map);
        System.out.println(value);

        // Iterate a Hashmap
        for (var item : map.keySet()) {
            System.out.println(item);
        }

        for (var item : map.entrySet())
            System.out.println(item.getValue());
    }
}

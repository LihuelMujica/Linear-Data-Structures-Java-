package hashtables;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(firstRepeatedCharWithSets("green apple"));
    }

    public void playingWithHashTables() {
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

    public static void playingWithSets() {
        Set<Integer> set = new HashSet<>();
        int [] numbers = { 1, 2, 3, 3, 2, 1, 4};
        for (var number : numbers)
            set.add(number);
        System.out.println(set);
    }

    public static Character firstNonRepeatedChar(String string) {
        string = string.toLowerCase(Locale.ROOT);

        Map<Character, Integer> map = new HashMap<>();

        var chars = string.toCharArray();
        for (char ch : chars) {
            if (!map.containsKey(ch))
                map.put(ch,0);
            map.put(ch, map.get(ch) + 1);
        }

        for (char ch : chars) {
            if (map.get(ch) == 1) return ch;
        }

        return Character.MIN_VALUE;
    }

    public static Character firstRepeatedChar(String string){
        Map<Character, Integer> map = new HashMap<>();
        string = string.toLowerCase(Locale.ROOT);
        for(Character ch: string.toCharArray()){
            Integer val = map.getOrDefault(ch, 0);
            map.put(ch, val + 1);
        }

        for(Character ch: string.toCharArray()) {
            if(map.get(ch) > 1) return ch;
        }

        return Character.MIN_VALUE;
    }

    public static Character firstRepeatedCharWithSets(String string) {
        Set<Character> set = new HashSet<>();
        string = string.toLowerCase(Locale.ROOT);
        for(Character ch: string.toCharArray()){
            if(set.contains(ch)) return ch;
            set.add(ch);
        }

        return Character.MIN_VALUE;
    }
}

package hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExercises {
    public Integer mostFrequentElement(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int number: array ) {
            int count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }
        Map.Entry<Integer, Integer> max = null;
        for (var set: map.entrySet()) {
            if (max == null)
                max = set;
            if (max.getValue() < set.getValue()) max = set;
        }

        return max.getKey();
    }

    public String mostFrequentWord(String string) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = string.split(" ");

        for (String word: words) {
            int count = map.getOrDefault(word, 0);
            map.put(word, count+1);
        }

        Map.Entry<String, Integer> max = null;
        for(var set: map.entrySet()) {
            if (max == null)
                max = set;
            if (max.getValue() < set.getValue()) max = set;
        }

        return max.getKey();
    }

    public Integer countPairsWithDiff(int[] array, int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int number: array) {
            set.add(number);
            if (set.contains(number + k)) count++;
            if (set.contains(number - k)) count++;
        }

        return count;
    }

    public int[] twoSum (int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] out = new int[2];

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            map.put(number, i);
            if (map.get(target - number) != null) {
                out[1] = i;
                out[0] = map.get(target - number);
            }
        }

        return out;
    }
}

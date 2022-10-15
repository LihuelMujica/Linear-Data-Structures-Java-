package hashtables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HashTableExercisesTest {
    HashTableExercises exercises;

    @BeforeEach
    public void inyector() {
        exercises = new HashTableExercises();
    }

    @Test
    public void mostFrequentElement() {
        int[] array = {1, 2, 2, 3, 3, 3, 4};
        assertEquals(3, exercises.mostFrequentElement(array));
    }

    @Test
    public void mostFrequentWord() {
        String text = "Habia una vez un perro que se llamaba perro salchicha";
        assertEquals("perro", exercises.mostFrequentWord(text));
    }

    @Test
    public void countPairsWithDiff() {
        int[] array = {1, 7, 5, 9, 2, 12, 3};

        assertEquals(4, exercises.countPairsWithDiff(array, 2));
    }

    @Test
    public void twoSum() {
        int[] array = {2, 7, 11, 15};
        int[] expected = {0, 1};

        assertEquals(Arrays.toString(expected), Arrays.toString(exercises.twoSum(array, 9)));
    }
}
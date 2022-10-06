package stacks;

import java.util.Arrays;

public class ArrayStack {
    int[] array;
    int count = 0;

    public void push(int val) {
        if (array.length == count ) resize();
        array[count++] = val;
    }

    private void resize() {
        int[] copy = array.clone();
        array = new int[array.length*2];
        for (int i = 0; i < copy.length ; i++) {
            array[i] = copy[i];
        }
    }

    public int pop() {
        if (count == 0)
            throw new IllegalStateException();
        return array[--count];
    }

    public int peek() {
        if (count == 0 )
            throw new IllegalStateException();

        return array[count-1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(
                Arrays.copyOfRange(array,0,count)
        );
    }

    public ArrayStack() {
        array = new int[5];
    }

    public ArrayStack(int length) {
        this.array = new int[length];
    }
}

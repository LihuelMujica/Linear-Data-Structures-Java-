package arrays;

import java.util.stream.Stream;

public class Array{
     int[] values;
     int count=0;

    public Array(Integer length) {
        this.values = new int[length];
    }

    public Array() {
        this.values = new int[0];
    }

    private void resize(int length){
        int[] copy = values.clone();
        values = new int[length];
        for (int i = 0; i < copy.length; i++) {
            values[i] = copy[i];
        }
    }

    public void insert(int value) {
        if(count==values.length) resize(values.length*2);
        values[count] = value;
        count++;
    }
}

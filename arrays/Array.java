package arrays;

import java.util.Arrays;
import java.util.stream.Collectors;
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

    public void removeAt(int pos) {
        int[] copy = values.clone();
        values = new int[values.length];
        for (int i = 0; i <count; i++) {
            if(i==pos) continue;
            values[i] = copy[i];
        }
        count--;
    }

    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (values[i] == value) return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        String out = "[";
        for (int i = 0; i < count; i++) {
            out += values[i];
            if(i<count-1) out+=",";
        }
        return out + "]";
    }
}

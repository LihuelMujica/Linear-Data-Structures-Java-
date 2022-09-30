package arrays;

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
        System.arraycopy(copy, 0, values, 0, copy.length);
    }

    public void insert(int value) {
        if(count==values.length) resize(values.length*2);
        values[count++] = value;
    }

    public void removeAt(int pos) {
        if (pos < 0 || pos >= count)
            throw new IllegalArgumentException();

        for (int i = pos; i < count; i++)
            values[i] = values[i+1];

        count --;
    }

    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (values[i] == value) return i;
        }
        return -1;
    }

    public int max() {
        if(count<=0) return -1;
        int max = values[0];
        for (int value: values) {
            if (value > max) max = value;
        }
        return max;
    }

    public Array intersect(Array other) {
        Array intersection = new Array(count);

        for (int i = 0; i < count; i++) {
            for (int value: other.values) {
                if(value == values[i]) intersection.insert(value);
            }
        }

        return intersection;
    }

    public void reverse(){
        for (int i = 0; i < count/2; i++) {
            int copy = values[i];
            values[i] = values[count-1-i];
            values[count-1-i] = copy;
        }
    }

    public void insertAt(int item, int index){
        if (index < 0 || index > count)
            throw new IllegalArgumentException();
        if (values.length==count) resize(count*2);
        for (int i = count-1; i >= index; i--) {
            values[i+1] = values[i];
        }
        values[index] = item;
        count++;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            out.append(values[i]);
            if(i<count-1) out.append(",");
        }
        return out + "]";
    }
}

package stacks;

public class TwoStacksOneArray {
    private final int[] items;
    private int count1;
    private int count2;


    public TwoStacksOneArray() {
        items = new int[5];
        count1 = 0;
        count2 = 0;
    }

    public void push1(int value) {
        if(count1+count2==5)
            throw new StackOverflowError();

        items[count1++] = value;
    }
    public void push2(int value) {
        if(count1+count2==5)
            throw new StackOverflowError();

        items[items.length-1-count2++] = value;
    }
    public int pop1() {
        if(count1 == 0)
            throw new IllegalStateException();
        return items[--count1];
    }

    public int pop2() {
        if(count2 == 0)
            throw new IllegalStateException();
        return items[items.length - 1 - --count2];
    }

    public boolean isEmpty1(){
        return count1 == 0;
    }

    public boolean isEmpty2(){
        return count2 == 0;
    }

    public boolean isFull1() {
        return count1+count2 == 5;
    }

    public boolean isFull2() {
        return isFull1();
    }



}
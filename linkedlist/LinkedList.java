package linkedlist;

import java.util.NoSuchElementException;
import java.util.Optional;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
    }

    public void addFirst(Integer value){
        Node newNode = new Node(value);
        newNode.next = first;
        if(isEmpty())
            last = first = newNode;
        else first = newNode;

        size++;
    }

    public void addLast(Integer value){
        Node newLast = new Node(value);
        if(!isEmpty()) last.next = newLast;
        else first = newLast;
        last = newLast;

        size++;
    }

    public void deleteFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            return;
        }
        Node oldFirst = first;
        first = oldFirst.next;
        oldFirst.next = null;

        size--;
    }

    public void deleteLast(){
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size--;
            return;
        }
        last = getPrevious(last);
        last.next = null;

        size--;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(Integer value){
        return indexOf(value) != -1;
    }

    public int indexOf(Integer value){
        Node node = first;
        for (int i = 0; node !=  null; i++) {
               if(node.value==value) return i;
               node = node.next;
        }
        return -1;
    }

    private boolean isEmpty(){
        return first == null;
    }

    public int size() {
        return this.size;
    }

    public Integer[] toArray() {
        Integer[] array = new Integer[size];
        Node current = first;
        for (int i = 0; i < size; i++) {
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if(isEmpty()) return;

        var prev = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = prev;
    }

    public int getKthFromTheEnd(int i){
        Node firstP = first; //10
        Node secondP = first; //10
        int count = 1;

        while(firstP.next != null) {
            firstP = firstP.next;  //20
            if (count >= i)
                secondP = secondP.next;
            count++;
        }

        if (secondP == null || count < i) throw new IllegalArgumentException();

        return secondP.value;

    }

    public void printMiddle(){
        Node firstP = first;
        Node secondP = first;
        int count = 0;
         while(firstP != null) {
            firstP = firstP.next;
            if ( count % 2 != 0) secondP = secondP.next;
            count ++;
        }

        if (count % 2 == 0) {
            System.out.println("Middle nodes: " + secondP.value + " " + (secondP.next).value);
        }
        else {
            System.out.println("Middle node: " + secondP.value);
        }


    }

    public void circleList() {
        if (last.next == null) {
            last.next = first;
        }
        else {
            last.next = null;
        }
    }

    public boolean hasLoop() {
        Node slow = first;
        Node fast = first;
        while(fast != null && fast.next != null) {
            fast = fast.next;
            if (fast == slow || fast.next == slow)
                return true;
            slow = slow.next;
            fast = fast.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        Node i = first;
        while (i != null) {
            out.append(i.value).append(",");
            i = i.next;
        }
        return out.substring(0,out.length()-1).concat("]");
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}

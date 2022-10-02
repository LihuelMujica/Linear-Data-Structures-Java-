package linkedlist;

import java.util.NoSuchElementException;

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

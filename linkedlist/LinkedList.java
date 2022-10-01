package linkedlist;

public class LinkedList {
    private Node first;
    private Node last;

    public LinkedList() {
    }

    public void addFirst(Integer value){
        first = new Node(value, first);
        if(last==null) last = first;
    }

    public void addLast(Integer value){
        Node newLast = new Node(value, null);
        if(last != null) last.setNext(newLast);
        last = newLast;
        if (first == null) first = last;
    }

    public void deleteFirst(){
        Node oldFirst = first;
        first = oldFirst.getNext();
        oldFirst.setNext(null);
    }

    public void deleteLast(){
        Node oldLast = last;
        Node i = first;
        while(i.getNext()!=last){
            i = i.getNext();
        }
        last = i;
        last.setNext(null);
        oldLast.setNext(null);
    }

    public boolean contains(Integer value){
        Node i = first;
        while (i.getNext()!=null){
            if(i.getValue() == value) return true;
            i = i.getNext();
        }
        return i.getValue() == value;
    }

    public int indexOf(Integer value){
        Node node = first;
        for (int i = 0; node.getNext()!=null; i++) {
               if(node.getValue()==value) return i;
               node = node.getNext();
               if(node.getValue()==value) return i+1;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        Node i = first;
        while (i != null) {
            out.append(i.getValue()).append(",");
            i = i.getNext();
        }
        return out.substring(0,out.length()-1).concat("]");
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }
}

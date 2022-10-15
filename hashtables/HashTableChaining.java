package hashtables;

import java.util.LinkedList;

public class HashTableChaining {
    LinkedList<Entry>[] array;


    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).add(
                new Entry(key, value));
    }

    public String get(int key){
        var entry = getEntry(key);

        return (entry == null) ? null : entry.value;
    }

    public void remove(int key){
        Entry entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);

//        LinkedList<Entry> list = array[hash(key)];
//        if(list!=null) {
//            for (Entry entry : list)
//                if (entry.key == key) {
//                    list.remove(entry);
//                    return;
//                }
//        }
//        throw new IllegalStateException();
    }

    private LinkedList<Entry> getBucket(int key) {
        return array[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        int index = hash(key);
        var bucket = array[index];
        if (bucket == null) {
            array[index] = new LinkedList<>();
            bucket = array[index];
        }
        return bucket;
    }

    private Entry getEntry(int key){
        var bucket = getBucket(key);
        if(bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key) return entry;
            }
        }
        return null;
    }

    public HashTableChaining(int n) {
        if(n<=0)
            throw new IllegalArgumentException();

        array = new LinkedList[n];
    }

    public int hash(int value) {
        return value % array.length;
    }

    private class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}

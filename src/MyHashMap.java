class MyHashMap {

    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int DEFAULT_CAPACITY = 16;
    private Entry[] table;
    private int size;


    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        this.table = new Entry[MyHashMap.DEFAULT_CAPACITY];
    }

    public MyHashMap(int capacity) {
        this.table = new Entry[capacity];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        if (this.size * 1.0 / this.table.length > DEFAULT_LOAD_FACTOR) {
            grow();
        }
        int index = computeIndex(key);
        Entry e = searchEntry(index, key);
        if (e == null) {
            Entry newEntry = new Entry(key, value);
            newEntry.next = this.table[index];
            this.table[index] = newEntry;
            this.size++;
        } else {
            e.value = value;
        }
    }

    private void grow() {
        MyHashMap newMap = new MyHashMap(this.table.length * 2);
        for (Entry e : this.table) {
            while (e != null) {
                newMap.put(e.key, e.value);
                e = e.next;
            }
        }
        this.table = newMap.table;
    }

    private Entry searchEntry(int index, int key) {
        if (this.table[index] == null) {
            return null;
        }
        for (Entry e = this.table[index]; e != null; e = e.next) {
            if (e.key == key) {
                return e;
            }
        }
        return null;
    }

    private int computeIndex(int key) {
        return key % table.length;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = computeIndex(key);
        Entry e = searchEntry(index, key);
        return e == null ? -1 : e.value;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = computeIndex(key);
        Entry it = this.table[index];
        if (it == null) {
            return;
        } else if (it.key == key) {
            this.table[index] = it.next;
            this.size--;
            return;
        }

        while (it.next != null) {
            if (it.next.key == key) {
                it.next = it.next.next;
                break;
            } else {
                it = it.next;
            }
        }
        this.size--;
    }

    private static class Entry {
        private final int key;
        private int value;
        private Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }


    }
}
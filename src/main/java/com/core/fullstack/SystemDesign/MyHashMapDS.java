package com.core.fullstack.SystemDesign;

class MyHashMap<K, V> {

    private static final int SIZE = 16;
    private Entry<K, V>[] table;

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @SuppressWarnings("unchecked")
    MyHashMap() {
        table = new Entry[SIZE];
    }

    public void put(K key, V value) {
        int index = key.hashCode() % SIZE;
        Entry<K, V> newEntry = new Entry<>(key, value, null);

        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    public V get(K key) {
        int index = key.hashCode() % SIZE;
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = key.hashCode() % SIZE;
        Entry<K, V> previous = null;
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }
}

public class MyHashMapDS {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("John", 25);
        map.put("Emily", 30);
        map.put("David", 40);

        System.out.println("John's age: " + map.get("John"));
        map.remove("John");
        System.out.println("John's age after removal: " + map.get("John"));
    }
}

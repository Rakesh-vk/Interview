package Misc.Cache;

import java.util.HashMap;
import java.util.Map;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {
            if (size == 0) {
                return null;
            }

            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    private final int capacity;
    private int minFreq;

    // key -> node
    private final Map<Integer, Node> cache;

    // freq -> DLL
    private final Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }

        updateFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        // Cache full
        if (cache.size() == capacity) {

            DoublyLinkedList minFreqList = freqMap.get(minFreq);

            Node nodeToRemove = minFreqList.removeLast();

            cache.remove(nodeToRemove.key);
        }

        Node newNode = new Node(key, value);

        cache.put(key, newNode);

        freqMap
                .computeIfAbsent(1, k -> new DoublyLinkedList())
                .addFirst(newNode);

        minFreq = 1;
    }

    private void updateFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap
                .computeIfAbsent(node.freq,
                        k -> new DoublyLinkedList())
                .addFirst(node);
    }
}
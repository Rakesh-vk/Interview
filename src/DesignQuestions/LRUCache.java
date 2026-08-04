package DesignQuestions;// ============================================================
// Algorithm Name: LRU Cache (Least Recently Used Cache)
// ============================================================

// ------------------------------------------------------------
// How It Works:
// ------------------------------------------------------------
// Combines a HashMap + Doubly Linked List to achieve O(1) get & put.
//
// Data Structures:
//   → HashMap<key, Node>  : gives O(1) access to any node directly
//   → Doubly Linked List  : maintains usage order (MRU at front, LRU at back)
//   → Dummy head & tail   : sentinel nodes to avoid null checks on edge cases
//
// Core Rules:
//   → Every GET moves the accessed node to the FRONT (most recently used)
//   → Every PUT (new key) inserts node at FRONT
//   → Every PUT (existing key) updates value and moves node to FRONT
//   → When capacity is full on PUT → evict tail.prev (least recently used)
//
// List Layout:
//   [head] ↔ [MRU] ↔ [...]  ↔ [LRU] ↔ [tail]
//    (dummy)                            (dummy)
// ------------------------------------------------------------

// ------------------------------------------------------------
// Time & Space Complexity:
// ------------------------------------------------------------
// Time  : O(1) for both get() and put() — HashMap lookup + pointer ops
// Space : O(capacity) — at most `capacity` nodes in map and list
// ------------------------------------------------------------

// ------------------------------------------------------------
// Revision Trick:
// ------------------------------------------------------------
// Think "VIP Queue with a Bouncer":
//   → HashMap is the guest list — instant lookup by name (key).
//   → Linked list is the VIP line — front is freshest, back is stalest.
//   → Every time someone is accessed, the bouncer (remove + insertAtFront)
//     moves them to the front. When capacity is full, the last person is evicted.
// ------------------------------------------------------------

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // Doubly linked list node storing key-value pair and pointers to neighbours
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;                  // Max number of entries the cache can hold
    private final Map<Integer, Node> cache;      // HashMap for O(1) key → node lookup

    private final Node head;                     // Dummy head sentinel (before MRU)
    private final Node tail;                     // Dummy tail sentinel (after LRU)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Sentinel nodes eliminate null checks during insert/remove at boundaries
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        // Initial empty list: head ↔ tail
        head.next = tail;
        tail.prev = head;
    }

    // Returns value if key exists (and marks it as recently used), else -1
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;          // Cache miss
        }

        Node node = cache.get(key);

        remove(node);           // Detach node from its current position
        insertAtFront(node);    // Re-insert right after head (most recently used)

        return node.value;
    }

    // Inserts or updates key-value pair; evicts LRU entry if over capacity
    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            // Key exists: update value and move to front (refresh recency)
            Node node = cache.get(key);
            node.value = value;

            remove(node);
            insertAtFront(node);
            return;
        }

        if (cache.size() == capacity) {
            // Cache full: evict the least recently used node (just before tail)
            Node lru = tail.prev;

            remove(lru);            // Unlink LRU node from list
            cache.remove(lru.key); // Remove from HashMap too
        }

        // Insert brand new node at front (most recently used position)
        Node newNode = new Node(key, value);

        insertAtFront(newNode);
        cache.put(key, newNode);    // Register in HashMap for future O(1) access
    }

    // Unlinks a node from the doubly linked list (does NOT touch the HashMap)
    private void remove(Node node) {
        node.prev.next = node.next;   // Left neighbour skips over node
        node.next.prev = node.prev;   // Right neighbour skips back over node
    }

    // Inserts a node immediately after head (MRU position)
    private void insertAtFront(Node node) {
        node.next = head.next;        // node → old first node
        node.prev = head;             // node ← head

        head.next.prev = node;        // old first node ← node
        head.next = node;             // head → node
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);             // List: [1]
        cache.put(2, 20);             // List: [2, 1]

        System.out.println(cache.get(1)); // 10  → List: [1, 2]  (1 moved to front)

        cache.put(3, 30);             // Capacity full → evict LRU (key=2) → List: [3, 1]

        System.out.println(cache.get(2)); // -1  → key 2 was evicted

        cache.put(4, 40);             // Evict LRU (key=1) → List: [4, 3]

        System.out.println(cache.get(1)); // -1  → key 1 was evicted
        System.out.println(cache.get(3)); // 30  → List: [3, 4]
        System.out.println(cache.get(4)); // 40  → List: [4, 3]
    }
}

// ============================================================
// Dry Run: capacity = 2
// ============================================================
//
// Initial State:
//   HashMap: {}
//   List:    [head] ↔ [tail]
//
// ─────────────────────────────────────────────────────────
// put(1, 10):
//   New key → insertAtFront(1,10) → cache.put(1, node)
//   HashMap: {1→Node(1,10)}
//   List:    [head] ↔ [1,10] ↔ [tail]
//
// ─────────────────────────────────────────────────────────
// put(2, 20):
//   New key → insertAtFront(2,20) → cache.put(2, node)
//   HashMap: {1→Node(1,10), 2→Node(2,20)}
//   List:    [head] ↔ [2,20] ↔ [1,10] ↔ [tail]
//
// ─────────────────────────────────────────────────────────
// get(1):  → returns 10
//   Found in map → remove(node1) → insertAtFront(node1)
//   HashMap: {1→Node(1,10), 2→Node(2,20)}
//   List:    [head] ↔ [1,10] ↔ [2,20] ↔ [tail]
//
// ─────────────────────────────────────────────────────────
// put(3, 30):
//   size(2) == capacity(2) → evict tail.prev = Node(2,20)
//   remove(node2), cache.remove(2)
//   insertAtFront(3,30), cache.put(3, node)
//   HashMap: {1→Node(1,10), 3→Node(3,30)}
//   List:    [head] ↔ [3,30] ↔ [1,10] ↔ [tail]
//
// get(2):  → returns -1  (evicted)
//
// ─────────────────────────────────────────────────────────
// put(4, 40):
//   size(2) == capacity(2) → evict tail.prev = Node(1,10)
//   remove(node1), cache.remove(1)
//   insertAtFront(4,40), cache.put(4, node)
//   HashMap: {3→Node(3,30), 4→Node(4,40)}
//   List:    [head] ↔ [4,40] ↔ [3,30] ↔ [tail]
//
// get(1):  → returns -1  (evicted)
// get(3):  → returns 30  → List: [head] ↔ [3,30] ↔ [4,40] ↔ [tail]
// get(4):  → returns 40  → List: [head] ↔ [4,40] ↔ [3,30] ↔ [tail]
// ============================================================
package com.akash.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * get(key)   → return value OR -1 if not found
 * put(key,value) → insert/update key, evict LRU if capacity exceeded
 * 
 * LRU = Least Recently Used → remove item that was accessed least recently.
 * Constraints:
 * Both get() and put() must be O(1) time.
 */
/**
 * 🎯 Idea Behind This Question (Interview Signal)
        The interviewer wants to verify:
        Can you design an O(1) time cache?
        Do you understand HashMap + Doubly Linked List combination?
        Do you understand eviction policy?
        Can you design custom data structures?
        This problem checks data structures + system design + memory management.
    
    📊 Complexity Comparison of All Approaches
    -------------------------------------------------------------------------------
    | Approach                  | get() | put() | Space | Notes                   |
    | ------------------------- | ----- | ----- | ----- | ----------------------- |
    | ❌ Brute force            | O(n)  | O(n)  | O(n)  | FAIL                    |
    | ✔ HashMap + DLL (BEST)    | O(1)  | O(1)  | O(n)  | Best for interviews     |
    | ✔ LinkedHashMap           | O(1)  | O(1)  | O(n)  | Not preferred but valid |
    -------------------------------------------------------------------------------
    🔥 CLEANEST & MOST PRODUCTION-READY JAVA CODE (BEST APPROACH)
 */
public class LRUCache146 {

    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private final Map<Integer, Node> map = new HashMap<>();
    private final int capacity;

    private final Node head = new Node(-1, -1);
    private final Node tail = new Node(-1, -1);

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insertToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existing = map.get(key);
            existing.value = value;
            remove(existing);
            insertToHead(existing);
            return;
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key, value);
        insertToHead(node);
        map.put(key, node);
    }

    private void insertToHead(Node node) {
        Node nextNode = head.next;
        node.next = nextNode;
        node.prev = head;
        head.next = node;
        nextNode.prev = node;
    }

    private void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }


    public static void main(String[] args) {
        /**
         * Input
         * ["LRUCache","put","put","get","put","get","put","get","get","get"]
         * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
         * 
         * OutPut
         * [null,null,null,1,null,-1,null,-1,3,4]
         */
        // 1. Initialize the cache with a capacity of 2
        LRUCache146 cache = new LRUCache146(2);

        System.out.println("--- Starting LRU Cache Test ---");

        // 2. Add some values
        cache.put(1, 1); // Cache is {1=1}
        cache.put(2, 2); // Cache is {1=1, 2=2}
        System.out.println("Put (1,1) and (2,2)");

        // 3. Get key 1
        System.out.println("Get(1): " + cache.get(1)); // Returns 1
        // Cache is now {2=2, 1=1} (1 moved to head because it was used)

        // 4. Add key 3, which should evict key 2
        cache.put(3, 3); 
        System.out.println("Put (3,3) - This should evict key 2");

        // 5. Try to get key 2
        System.out.println("Get(2): " + cache.get(2)); // Returns -1 (not found)

        // 6. Add key 4, which should evict key 1 (because 1 was used before 3)
        cache.put(4, 4);
        System.out.println("Put (4,4) - This should evict key 1");

        System.out.println("Get(1): " + cache.get(1)); // Returns -1 (not found)
        System.out.println("Get(3): " + cache.get(3)); // Returns 3
        System.out.println("Get(4): " + cache.get(4)); // Returns 4
        
        System.out.println("--- Test Complete ---");
    }
    /*
        ✔ O(1) operations
        ✔ Clean
        ✔ Production-quality
        ✔ Does not use Java's LinkedHashMap (interviewers prefer custom implementation)
    */
    
    /**
     * 🧠 APPROACH 1 — HashMap + Doubly Linked List (BEST Approach)
            Why it works?
                ✔ HashMap gives O(1) lookup
                ✔ DLL gives O(1) add-remove from head-tail
                ✔ Most recently used → move to head
                ✔ Least recently used → remove from tail
            This is the industry standard implementation.
        
    📌 Data Structure Design

    We maintain:

        1. HashMap<Integer, Node> map
            key → node (contains key & value)
            lookup is O(1)
        2. Doubly Linked List
            head = most recently used
            tail = least recently used
        DLL Node contains:
     */
    /**
     * 💡 Steps
            GET(key)
                If not in map → return -1
                Move node to head (most recently used)
                Return value
            PUT(key, value)
                If key exists → update value & move to head
                If capacity full → remove tail node
                Insert new node at head
                Put in map
            All operations are O(1).
        
        🧮 Time & Space Complexity
        ------------------------------------------------------------------------
        | Operation | Best Case | Worst Case | Explanation                    |
        | --------- | --------- | ---------- | ------------------------------ |
        | get()     | O(1)      | O(1)       | HashMap lookup + O(1) DLL move |
        | put()     | O(1)      | O(1)       | Insert/move/delete DLL node    |
        | Space     | O(n)      | O(n)       | storing n keys in map + DLL    |
        -----------------------------------------------------------------------
     * 
     */


    /**
     * 🧠 APPROACH 2 — Using LinkedHashMap (Easy but not preferred in interviews)
     * 📊 Complexity Comparison of All Approaches
     *  ----------------------------------------------------------------------------
     *  | Approach               | get() | put() | Space | Notes                    |
        | ---------------------- | ----- | ----- | ----- | -----------------------  |
        | ❌ Brute force          | O(n)  | O(n)  | O(n)  | FAIL                    |
        | ✔ HashMap + DLL (BEST) | O(1)  | O(1)  | O(n)  | Best for interviews      |
        | ✔ LinkedHashMap        | O(1)  | O(1)  | O(n)  | Not preferred but valid  |
        ------------------------------------------------------------------------------

     */

    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
            return size() > capacity;
        }
    }

}

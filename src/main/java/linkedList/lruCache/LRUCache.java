package linkedList.lruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private class DListNode {
        // Node class for the doubly linked list
        int key;
        int value;
        DListNode prev;
        DListNode next;

        DListNode (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity; // Maximum capacity of the cache
    private final Map<Integer, DListNode> map; // HashMap to store key -> node mappings
    private final DListNode head, tail; // Dummy head and tail nodes for doubly linked list

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        // Use dummy head and tail nodes to make insertion and removal logic easier (no need to check for null nodes).
        this.head = new DListNode(-1, -1);
        this.tail = new DListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    // Get the value of the key if it exists, otherwise return -1
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DListNode node = map.get(key);
        removeNode(node);
        addNodeToBack(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DListNode oldNode = map.get(key);
            removeNode(oldNode);
        }

        DListNode newNode = new DListNode(key, value);
        map.put(key, newNode);
        addNodeToBack(newNode);

        if (map.size() > capacity) {
            // Always remove LRU node which is present front of the DLL
            DListNode LRUNodeToBeDeleted = head.next;
            removeNode(LRUNodeToBeDeleted);
            map.remove(LRUNodeToBeDeleted.key);
        }
    }

    public void addNodeToBack(DListNode node) {
        DListNode nodePreviousToTailNode = tail.prev;
        nodePreviousToTailNode.next = node;
        node.prev = nodePreviousToTailNode;
        node.next = tail;
        tail.prev = node;
    }

    public void removeNode(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

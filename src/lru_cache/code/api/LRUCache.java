package lru_cache.code.api;

import lru_cache.code.ds.DoublyLinkedList;
import lru_cache.code.ds.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private final Map<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> list;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList<>();
    }

    /**
     * 1. If key not in map, return null
     * 2. Get the node from the map
     * 3. Move the node to front (mark as most recently used)
     * 4. Return the node's value */
    public synchronized V get(K key) {

        if(!(map == null || map.isEmpty() || !map.containsKey(key))) {
            Node<K, V> node = map.get(key);
            list.moveToFront(node);
            return node.getValue();
        }
        return null;
    }

    /** Case 1: Key already exists
       - Get the existing node
       - Update its value
       - Move it to front

     Case 2: Key is new
       - If at capacity, evict LRU item:
         - Remove last node from list
         - Remove its key from map
       - Create new node
       - Add to front of list
       - Add to map */
    public synchronized void put(Node<K, V> node) {

        if(!(map == null || map.isEmpty())) {
            K key = node.getKey();

            if(map.containsKey(key)) {
                Node existingNode  = map.get(key);
                existingNode.setValue(node.getValue());
                list.moveToFront(existingNode);
            } else {
                // new node
                node.setNext(null);
                node.setPrev(null);

                if(map.size() == capacity) {

                    Node<K, V> lastNode = list.removeLast();
                    if(lastNode != null) {
                        map.remove(lastNode.getKey());
                    }
                }

                list.addFirst(node);
                map.put(key, node);
            }
        }
    }

}

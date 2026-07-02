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


}

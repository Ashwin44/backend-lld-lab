package lru_cache.code.ds;

public class DoublyLinkedList<K,V> {

    private Node<K,V> head;
    private Node<K,V> tail;

    public DoublyLinkedList() {
    }

    public Node<K, V> getHead() {
        return head;
    }

    public void setHead(Node<K, V> head) {
        this.head = head;
    }

    public Node<K, V> getTail() {
        return tail;
    }

    public void setTail(Node<K, V> tail) {
        this.tail = tail;
    }

    public void addFirst(Node<K, V> node) {

    }

    public void removeLast() {

    }

    public void moveToFront(Node<K, V> node) {

    }

}

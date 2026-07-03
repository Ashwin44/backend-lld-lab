package lru_cache.code.ds;

public class DoublyLinkedList<K,V> {

    private final Node<K,V> head;
    private final Node<K,V> tail;

    public DoublyLinkedList() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.setNext(tail);
        head.setPrev(null);
        tail.setPrev(head);
        tail.setNext(null);
    }

    public Node<K, V> getHead() {
        return head;
    }

    public Node<K, V> getTail() {
        return tail;
    }

    public void addFirst(Node<K, V> node) {
        Node next = head.getNext();
        head.setNext(node);
        next.setPrev(node);
        node.setPrev(head);
        node.setNext(next);
    }

    public Node<K, V> removeLast() {

        if(tail.getPrev() != head) {
            Node lastNode = tail.getPrev();
            Node prevNode = lastNode.getPrev();
            prevNode.setNext(lastNode.getNext());
            tail.setPrev(prevNode);
            lastNode.setPrev(null);
            lastNode.setNext(null);
            return lastNode;
        }
        return null;
    }

    public void moveToFront(Node<K, V> node) {
        Node prev = node.getPrev();
        Node next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        node.setPrev(null);
        node.setNext(null);
        addFirst(node);
    }

}

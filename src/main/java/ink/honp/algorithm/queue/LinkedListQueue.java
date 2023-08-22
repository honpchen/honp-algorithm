package ink.honp.algorithm.queue;

import java.util.Iterator;

/**
 * 链表队列实现
 * @author jeff chen
 * @since 1.0.0
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    private final Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;

    public LinkedListQueue() {
        tail.next = head;
    }

    @Override
    public boolean offer(E value) {
        Node<E> addedNode = new Node<>(value, head);
        tail.next = addedNode;
        tail = addedNode;

        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        Node<E> first = head.next;
        head.next = first.next;
        if (first == tail) {
            tail = head;
        }

        return first.value;
    }

    @Override
    public E peak() {
        if (isEmpty()) {
            return null;
        }

        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;

                return value;
            }
        };
    }

    /**
     * 内部节点类
     */
    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}

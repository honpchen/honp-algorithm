package ink.honp.algorithm.queue;

import java.util.Iterator;

/**
 * 双端队列链表实现
 * @author jeff chen
 * @since 2023-09-01 9:26
 */
public class LinkedDeque<E> implements Deque<E>, Iterable<E> {

    private final Node<E> sentinel = new Node<>(null, null, null);
    private final int capacity;

    private int size = 0;

    public LinkedDeque(int capacity) {
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        this.capacity = capacity;
    }

    @Override
    public boolean offerFirst(E value) {
        if (isFull()) {
            return false;
        }

        // s first next
        Node<E> pre = sentinel;
        Node<E> next = sentinel.next;
        Node<E> firstNode = new Node<>(pre, value, next);

        pre.next = firstNode;
        next.pre = firstNode;

        size++;

        return true;
    }

    @Override
    public boolean offerLast(E value) {
        if (isFull()) {
            return false;
        }

        // pre last s
        Node<E> pre = sentinel.pre;
        Node<E> next = sentinel;
        Node<E> lastNode = new Node<>(pre, value, next);

        pre.next = lastNode;
        next.pre = lastNode;

        size++;

        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }

        // s first n
        Node<E> firsNode = sentinel.next;
        sentinel.next = firsNode.next;
        firsNode.next.pre = sentinel;

        size--;

        return firsNode.value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }

        // p n s
        Node<E> lastNode = sentinel.pre;
        lastNode.pre.next = sentinel;
        sentinel.pre = lastNode.pre;

        size--;

        return lastNode.value;
    }

    @Override
    public E peakFirst() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.next.value;
    }

    @Override
    public E peakLast() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.pre.value;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean isFull() {
        return this.size == this.capacity;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<>() {

            private Node<E> p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node<E> {

        Node<E> pre;
        E value;
        Node<E> next;

        public Node(Node<E> pre, E value, Node<E> next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }
}

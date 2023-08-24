package ink.honp.algorithm.stack;

import java.util.Iterator;

/**
 * @author jeff chen
 * @since 1.0.0
 */
public class LinkedListStack <E> implements Stack<E>, Iterable<E> {

    private final Node<E> head = new Node<>(null, null);
    private final int capacity;
    private int size;

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
        this.size = 0;

    }


    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        this.head.next = new Node<>(value, this.head.next);
        this.size++;

        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E value = this.head.next.value;
        this.head.next = this.head.next.next;
        this.size--;

        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return this.head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return null == this.head.next;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return null != p;
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

        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

}

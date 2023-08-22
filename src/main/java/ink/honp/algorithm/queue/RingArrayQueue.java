package ink.honp.algorithm.queue;

import java.util.Iterator;

/**
 * 环形数组实现队列
 * @author jeff chen
 * @since 1.0.0
 */
public class RingArrayQueue<E> implements Queue<E>, Iterable<E> {

    private int head = 0;
    private int tail = 0;
    private final E[] data;

    @SuppressWarnings("all")
    public RingArrayQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        tail = getNextIndex(tail);

        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        E value = data[head];
        head = getNextIndex(head);

        return value;
    }

    @Override
    public E peak() {
        if (isEmpty()) {
            return null;
        }
        return data[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % data.length == head;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<>() {
            private int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = data[p];
                p = getNextIndex(p);
                return value;
            }
        };
    }

    private int getNextIndex(int currentIndex) {
        return (currentIndex + 1) % data.length;
    }
}

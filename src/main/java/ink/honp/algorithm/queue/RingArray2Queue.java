package ink.honp.algorithm.queue;

import java.util.Iterator;

/**
 * 环形数组实现队列 2
 * @author jeff chen
 * @since 1.0.0
 */
public class RingArray2Queue<E> implements Queue<E>, Iterable<E> {

    private int head = 0;
    private int tail = 0;
    private final E[] data;

    @SuppressWarnings("all")
    public RingArray2Queue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        data[index(tail)] = value;
        tail++;

        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        E value = data[index(head)];
        head++;

        return value;
    }

    @Override
    public E peak() {
        if (isEmpty()) {
            return null;
        }
        return data[index(head)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == data.length;
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
                E value = data[index(p)];
                p++;
                return value;
            }
        };
    }

    private int index(int point) {
        return point % data.length;
    }
}

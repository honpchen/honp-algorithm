package ink.honp.algorithm.stack;

import java.util.Iterator;

/**
 * @author jeff chen
 * @since 1.0.0
 */
public class ArrayStack<E> implements Stack<E>, Iterable<E> {

    private final E[] data;
    private int top;

    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.top = 0;
    }


    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        this.data[top++] = value;

        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }

        return this.data[--top];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return this.data[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.top == 0;
    }

    @Override
    public boolean isFull() {
        return this.top == this.data.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int p = top;

            @Override
            public boolean hasNext() {
                return p > 0;
            }

            @Override
            public E next() {
                return data[--p];
            }
        };
    }
}

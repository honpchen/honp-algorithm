package ink.honp.algorithm.queue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jeff chen
 * @since 1.0.0
 */
public class SingleLockBlockingQueue <E> implements BlockingQueue<E> {

    private E[] data;

    private int head = 0;
    private int tail = 0;
    private int size = 0;

    private ReentrantLock lock = new ReentrantLock();
    private Condition headWait = lock.newCondition();
    private Condition tailWait = lock.newCondition();

    @SuppressWarnings("all")
    public SingleLockBlockingQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) throws InterruptedException {
        return offer(value, 0);
    }

    @Override
    public boolean offer(E value, long timeout) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            long waitTime = TimeUnit.MICROSECONDS.toNanos(timeout);
            while (isFull()) {
                if (waitTime <= 0) {
                    return false;
                }
                waitTime = tailWait.awaitNanos(waitTime);
            }
            data[tail] = value;
            if (++tail == data.length) {
                tail = 0;
            }
            size++;
            headWait.signal();

            return true;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWait.await();
            }

            E value = data[head];
            data[head] = null;
            if (++head == data.length) {
                head = 0;
            }
            tailWait.signal();

            return value;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}

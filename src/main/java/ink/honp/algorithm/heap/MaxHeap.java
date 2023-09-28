package ink.honp.algorithm.heap;

import ink.honp.algorithm.Priority;

import java.util.Iterator;

/**
 * @author jeff chen
 * @since 1.0.0
 */
public class MaxHeap <E extends Priority> implements Iterable<E>{

    private Priority[] arrays;

    private int size;

    public MaxHeap(int capacity) {
        this.arrays = new Priority[capacity];
        this.size = 0;
    }

    public MaxHeap(Priority[] arrays) {
        this.arrays = arrays;
        this.size = arrays.length;

        this.heapify();
    }

    public boolean offer(Priority priority) {
        if (isFull()) {
            return false;
        }

        up(priority);
        size++;

        return true;
    }

    public E peak() {
        if (isEmpty()) {
            return null;
        }

        return (E) arrays[0];
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }

        swap(0, --size);

        Priority data = arrays[size];
        arrays[size] = null;

        down(0);

        return (E) data;
    }

    /**
     * 替换堆顶元素
     * @param priority
     */
    public void replaceTop(Priority priority) {
        arrays[0] = priority;

        down(0);
    }

    public boolean isFull() {

        return this.size == this.arrays.length;
    }

    public boolean isEmpty() {

        return this.size == 0;
    }

    /**
     * 构建大顶堆
     * 1. 查找到最后的非叶子节点
     * 2. 将最后的非叶子节点之前的节点下浅比较
     */
    private void heapify() {
        if (isEmpty()) {
            return;
        }

        int lastNoLeafIndex = this.size / 2 - 1;
        for (int i = lastNoLeafIndex; i >= 0; i--) {
            down(i);
        }
    }

    /**
     * 上浮
     * @param priority
     */
    private void up(Priority priority) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (arrays[parent].getPriority() > priority.getPriority()) {
                arrays[child] = arrays[parent];
                child = parent;
            } else {
                break;
            }
        }
        arrays[child] = priority;
    }

    /**
     * 下浅
     */
    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;

        int max = parent;
        if (left < size && arrays[left].getPriority() > arrays[max].getPriority()) {
            max = left;
        }

        if (right < size && arrays[right].getPriority() > arrays[max].getPriority()) {
            max = right;
        }

        if (max != parent) {
            swap(max, parent);
            down(max);
        }
    }


    private void swap(int i, int j) {
        Priority tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }


    @Override
    public Iterator<E> iterator() {

        return new Iterator<>() {
            int p = 0;

            @Override
            public boolean hasNext() {
                return p != size;
            }

            @Override
            public E next() {
                Priority ele = arrays[p];
                p++;
                return (E) ele;
            }
        };
    }
}

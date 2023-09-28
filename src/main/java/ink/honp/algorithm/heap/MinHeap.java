package ink.honp.algorithm.heap;

/**
 * @author jeff chen
 * @since 1.0.0
 */
public class MinHeap {

    private int size;
    private final int[] arrays;


    public MinHeap(int capacity) {
        this.arrays = new int[capacity];
        this.size = 0;
    }

    public MinHeap(int[] arrays) {
        this.arrays = arrays;
        this.size = arrays.length;

        this.heapify();
    }

    public boolean offer(int val) {
        if (isFull()) {
            return false;
        }

        up(val);
        size++;

        return true;
    }

    public int peak() {
        return arrays[0];
    }

    public int poll() {

        swap(0, --size);

        int data = arrays[size];

        down(0);

        return data;
    }

    /**
     * 替换堆顶元素
     * @param val 新元素
     */
    public void replace(int val) {
        arrays[0] = val;

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

        int lastNoLeafIndex = this.size / 2 - 1;
        for (int i = lastNoLeafIndex; i >= 0; i--) {
            down(i);
        }
    }

    /**
     * 上浮
     * @param val 插入值
     */
    private void up(int val) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (val < arrays[parent]) {
                arrays[child] = arrays[parent];
                child = parent;
            } else {
                break;
            }
        }
        arrays[child] = val;
    }

    /**
     * 下浅
     */
    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;

        int min = parent;
        if (left < size && arrays[left] < arrays[min]) {
            min = left;
        }

        if (right < size && arrays[right] > arrays[min]) {
            min = right;
        }

        if (min != parent) {
            swap(min, parent);
            down(min);
        }
    }


    private void swap(int i, int j) {
        int tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }
}

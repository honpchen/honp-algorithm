package ink.honp.algorithm.heap;

import ink.honp.algorithm.Priority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author jeff chen
 * @since 1.0.0
 */
class MaxHeapTest {

    @Test
    @DisplayName("大顶堆测试")
    void test() {

        Entry<Integer>[] arrays = new Entry[7];
        for (int i = 0; i < arrays.length; i++) {
            int value = i + 1;
            arrays[i] = new Entry<>(value, value);
        }

        MaxHeap<Entry> maxHeap = new MaxHeap<>(arrays);

        Assertions.assertEquals(7, maxHeap.poll().priority);
        Assertions.assertEquals(6, maxHeap.poll().priority);
        Assertions.assertEquals(5, maxHeap.poll().priority);
        Assertions.assertEquals(4, maxHeap.poll().priority);
        Assertions.assertEquals(3, maxHeap.poll().priority);
        Assertions.assertEquals(2, maxHeap.poll().priority);
        Assertions.assertEquals(1, maxHeap.poll().priority);

        Assertions.assertNull(maxHeap.poll());
    }

    public static class Entry<E> implements Priority {

        E value;
        int priority;

        public Entry(E value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        @Override
        public int getPriority() {
            return priority;
        }
    }
}

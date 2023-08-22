package ink.honp.algorithm.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author jeff chen
 * @since 1.0.0
 */
class RingArray2QueueTest {

    @Test
    @DisplayName("环形队列2添加")
    void testOffer() {
        RingArray2Queue<Integer> queue = new RingArray2Queue<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        Assertions.assertIterableEquals(List.of(1,2,3,4,5), queue);
    }

    @Test
    @DisplayName("从环形队列2头部取值不删除")
    void testPeek() {
        RingArray2Queue<Integer> queue = new RingArray2Queue<>(5);
        Assertions.assertNull(queue.peak());

        queue.offer(1);

        Integer value = queue.peak();
        Assertions.assertEquals(1, value);

        queue.offer(2);
        value = queue.peak();
        Assertions.assertEquals(1, value);
    }

    @Test
    @DisplayName("从环形队列2头部取值并移除")
    void testPoll() {
        RingArray2Queue<Integer> queue = new RingArray2Queue<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        Assertions.assertEquals(1, queue.poll());
        Assertions.assertEquals(2, queue.poll());
        Assertions.assertEquals(3, queue.poll());
        Assertions.assertEquals(4, queue.poll());
        Assertions.assertEquals(5, queue.poll());
        Assertions.assertNull(queue.poll());
    }

}

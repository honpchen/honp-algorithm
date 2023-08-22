package ink.honp.algorithm.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author jeff chen
 * @since 1.0.0
 */
class LinkedListQueueTest {

    @Test
    @DisplayName("测试链表队列添加")
    void testOffer() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        Assertions.assertIterableEquals(List.of(1,2,3,4,5), queue);
    }

    @Test
    @DisplayName("测试从链表队列头部取值不删除")
    void testPeek() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        Assertions.assertNull(queue.peak());

        queue.offer(1);

        Integer value = queue.peak();
        Assertions.assertEquals(1, value);

        queue.offer(2);
        value = queue.peak();
        Assertions.assertEquals(1, value);
    }

    @Test
    @DisplayName("测试从链表队列头部取值并移除")
    void testPoll() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
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

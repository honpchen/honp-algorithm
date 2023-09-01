package ink.honp.algorithm.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author jeff chen
 * @since 1.0.0
 */
class LinkedDequeTest {

    @Test
    @DisplayName("双端队列头添加")
    void testOfferFirst() {
        LinkedDeque<Integer> queue = new LinkedDeque<>(5);
        queue.offerFirst(1);
        queue.offerFirst(2);
        queue.offerFirst(3);
        queue.offerFirst(4);
        queue.offerFirst(5);

        Assertions.assertFalse(queue.offerFirst(6));

        Assertions.assertIterableEquals(List.of(5,4,3,2,1), queue);
    }

    @Test
    @DisplayName("双端队列尾添加")
    void testOfferLast() {
        LinkedDeque<Integer> queue = new LinkedDeque<>(5);
        queue.offerLast(1);
        queue.offerLast(2);
        queue.offerLast(3);
        queue.offerLast(4);
        queue.offerLast(5);

        Assertions.assertFalse(queue.offerLast(6));

        Assertions.assertIterableEquals(List.of(1,2,3,4,5), queue);
    }

    @Test
    @DisplayName("双端队列头部取值不删除")
    void testPeekFirst() {
        LinkedDeque<Integer> queue = new LinkedDeque<>(5);
        Assertions.assertNull(queue.peakFirst());

        queue.offerFirst(1);

        Integer value = queue.peakFirst();
        Assertions.assertEquals(1, value);

        queue.offerFirst(2);
        value = queue.peakFirst();
        Assertions.assertEquals(2, value);
    }


    @Test
    @DisplayName("双端队列尾部取值不删除")
    void testPeekLast() {
        LinkedDeque<Integer> queue = new LinkedDeque<>(5);
        Assertions.assertNull(queue.peakFirst());

        queue.offerFirst(1);

        Integer value = queue.peakLast();
        Assertions.assertEquals(1, value);

        queue.offerFirst(2);
        value = queue.peakLast();
        Assertions.assertEquals(1, value);
    }

    @Test
    @DisplayName("双端队列头部取值并移除")
    void testPollFirst() {
        LinkedDeque<Integer> queue = new LinkedDeque<>(5);
        queue.offerLast(1);
        queue.offerLast(2);
        queue.offerLast(3);
        queue.offerLast(4);
        queue.offerLast(5);

        Assertions.assertEquals(1, queue.pollFirst());
        Assertions.assertEquals(2, queue.pollFirst());
        Assertions.assertEquals(3, queue.pollFirst());
        Assertions.assertEquals(4, queue.pollFirst());
        Assertions.assertEquals(5, queue.pollFirst());
        Assertions.assertNull(queue.pollFirst());
    }


    @Test
    @DisplayName("双端队列尾部取值并移除")
    void testPollLast() {
        LinkedDeque<Integer> queue = new LinkedDeque<>(5);
        queue.offerLast(1);
        queue.offerLast(2);
        queue.offerLast(3);
        queue.offerLast(4);
        queue.offerLast(5);

        Assertions.assertEquals(5, queue.pollLast());
        Assertions.assertEquals(4, queue.pollLast());
        Assertions.assertEquals(3, queue.pollLast());
        Assertions.assertEquals(2, queue.pollLast());
        Assertions.assertEquals(1, queue.pollLast());
        Assertions.assertNull(queue.pollLast());
    }

}

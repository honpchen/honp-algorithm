package ink.honp.algorithm.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author jeff chen
 * @since 1.0.0
 */
class ArrayStackTest {

    @Test
    @DisplayName("栈顶压入元素")
    void testPush() {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Assertions.assertFalse(stack.push(6));

        Assertions.assertIterableEquals(List.of(5,4,3,2,1), stack);
    }

    @Test
    @DisplayName("栈顶弹出元素")
    void testPop() {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Assertions.assertEquals(5, stack.pop());
        Assertions.assertEquals(4, stack.pop());
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
        Assertions.assertNull(stack.pop());
    }

}

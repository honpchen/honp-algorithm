package ink.honp.algorithm.stack;

/**
 * 栈接口
 * @author jeff chen
 * @since 2023-08-24 11:10
 */
public interface Stack <E> {

    /**
     * 栈顶压入元素
     * @param  value 元素
     * @return 成功返回 {@code true}, 失败返回 {@code false}
     */
    boolean push(E value);

    /**
     * 从栈顶弹出元素
     * @return 栈非空弹出元素，栈为空则返回 {@code null}
     */
    E pop();

    /**
     * 从栈顶获取元素，但不弹出
     * @return 栈非空返回栈顶元素，栈为空则返回 {@code null}
     */
    E peek();

    /**
     * 栈是否为空
     * @return 空返回 {@code true}, 非空返回 {@code false}
     */
    boolean isEmpty();

    /**
     * 栈是否已满
     * @return 满返回 {@code true}, 否则返回 {@code false}
     */
    boolean isFull();
}

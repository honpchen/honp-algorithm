package ink.honp.algorithm.queue;

/**
 * @author jeff chen
 * @since 1.0.0
 */
public interface Queue<E> {

    /**
     * 向队列尾插入值
     * @param value 待插入值
     * @return 成功返回 {@code true}, 失败返回 {@code false}
     */
    boolean offer(E value);

    /**
     * 从队列头部取值，并移除
     * @return 如果队列非空则返回头部值，否则返回 {@code null}
     */
    E poll();

    /**
     * 从队列头部取值，不移除
     * @return 如果队列非空则返回头部值，否则返回 {@code null}
     */
    E peak();

    /**
     * 检查队列是否为空
     * @return 空返回 {@code true}, 否则返回 {@code false}
     */
    boolean isEmpty();

    /**
     * 队列是否已满
     * @return 满返回 {@code true}, 不满返回 {@code false}
     */
    boolean isFull();
}

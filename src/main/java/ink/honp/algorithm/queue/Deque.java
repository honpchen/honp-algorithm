package ink.honp.algorithm.queue;

/**
 * 双端队列
 * @author jeff chen
 * @since 1.0.0
 */
public interface Deque<E> {

    /**
     * 向队列头插入值
     * @param value 待插入值
     * @return 成功返回 {@code true}, 失败返回 {@code false}
     */
    boolean offerFirst(E value);

    /**
     * 向队列尾插入值
     * @param value 待插入值
     * @return 成功返回 {@code true}, 失败返回 {@code false}
     */
    boolean offerLast(E value);

    /**
     * 从队列头部取值，并移除
     * @return 如果队列非空则返回头部值，否则返回 {@code null}
     */
    E pollFirst();


    /**
     * 从队列尾取值，并移除
     * @return 如果队列非空则返回头部值，否则返回 {@code null}
     */
    E pollLast();

    /**
     * 从队列头部取值，不移除
     * @return 如果队列非空则返回头部值，否则返回 {@code null}
     */
    E peakFirst();

    /**
     * 从队列尾取值，不移除
     * @return 如果队列非空则返回头部值，否则返回 {@code null}
     */
    E peakLast();

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

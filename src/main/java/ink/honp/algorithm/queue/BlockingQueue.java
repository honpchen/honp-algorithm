package ink.honp.algorithm.queue;

/**
 * @author jeff chen
 * @since 2023-09-05 15:18
 */
public interface BlockingQueue <E> {

    /**
     * 插入元素,若队列已满则阻塞等待
     * @param value 元素
     * @throws InterruptedException 中断异常
     */
    boolean offer(E value) throws InterruptedException;

    /**
     * 插入元素,若队列已满则阻塞等待指定时间
     * @param value 元素
     * @param timeout 超时时间，毫秒
     * @throws InterruptedException 中断异常
     */
    boolean offer(E value, long timeout) throws InterruptedException;

    /**
     * 弹出元素， 若队列为空则阻塞等待
     * @return -
     * @throws InterruptedException 中断异常
     */
    E poll() throws InterruptedException;

    boolean isEmpty();

    boolean isFull();
}

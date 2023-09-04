package ink.honp.algorithm.leetcode;

/**
 * @author jeff chen
 * @since 1.0.0
 */
public class LeetCode23 {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode node3 = new ListNode(2, new ListNode(6, null));
        
        ListNode[] nodes = new ListNode[]{node1, node2, node3};

        ListNode listNode = new LeetCode23().mergeKLists(nodes);
        System.out.println(listNode);
    }


    public ListNode mergeKLists(ListNode[] lists) {
        // 先将节点插入到小顶堆
        MinHead minHead = new MinHead(lists.length);
        for (ListNode node : lists) {
            if (null != node) {
                minHead.offer(node);
            }
        }

        ListNode s = new ListNode(0, null);
        ListNode minNode = s;

        while (!minHead.isEmpty()) {
            ListNode node = minHead.poll();
            minNode.next = node;
            minNode = node;
            if (node.next != null) {
                minHead.offer(node.next);
            }
        }

        return s.next;

    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /**
     * 小顶堆代码实现
     */
    private static class MinHead {

        private final ListNode[] data;

        private int size = 0;

        public MinHead(int capaticy) {
            data = new ListNode[capaticy];
        }

        /**
         * 插入元素
         * <p>
         *    1. 将节点模拟插入最后的节点(先不插入，需进行比较)
         *    2. 比较节点的父节点是否小于子节点，若大于，则将父节点下移动到子节点，直到子节点的索引为 0
         * </p>
         * @param node 节点
         * @return 成功返回 true, 否则返回 false
         */
        public boolean offer(ListNode node) {
            if (isFull()) {
                return false;
            }

            int child = size++;
            int parent = (child - 1) / 2;
            while (child != 0 && node.val < data[parent].val) {
                data[child] = data[parent];
                child = parent;
                parent = (child - 1) / 2;
            }
            data[child] = node;

            return true;
        }

        /**
         * 1. 先首尾交换
         * 2. 弹出尾部元素
         * 3. 下潜
         *    将父节点与左右最小子节点比较，若父节点比其大，则需要交换
         * @return
         */
        public ListNode poll() {
            if (isEmpty()) {
                return null;
            }

            swap(0 , size - 1);

            ListNode node = data[size - 1];
            data[size - 1] = null;
            size--;

            down(0);

            return node;
        }


        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == data.length;
        }


        private void down(int parent) {
            int left = 2*parent + 1;
            int right = left + 1;

            int min = parent;
            if (left < size && data[left].val < data[min].val) {
                min = left;
            }

            if (right < size && data[right].val < data[min].val) {
                min = right;
            }

            if (min != parent) {
                swap(min, parent);
                down(min);
            }
        }


        private void swap(int i, int j) {
            ListNode tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
    }
}

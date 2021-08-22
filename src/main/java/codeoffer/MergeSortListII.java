package codeoffer;

import base.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/8/22
 * 描述：合并k个升序链表
 * 思路：使用优先队列优化
 */
public class MergeSortListII {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(this::compareTo);
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }

    public int compareTo(ListNode node1, ListNode node2) {
        return node1.val - node2.val;
    }
}

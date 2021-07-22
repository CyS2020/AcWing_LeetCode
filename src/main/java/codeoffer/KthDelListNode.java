package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/7/22
 * 描述：删除链表的倒数第 K 个结点
 * 思路：双指针算法，获取单链表节点的前一个节点时，借助dummy往前偏移一下
 */
public class KthDelListNode {

    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

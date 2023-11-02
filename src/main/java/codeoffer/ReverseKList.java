package codeoffer;

import base.ListNode;

/**
 * @author: CyS2020
 * @date: 2021/5/14
 * 描述：k 个一组反转链表
 */
public class ReverseKList {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = dummy;
        while (cur.next != null) {
            for (int i = 0; i < k && cur != null; i++) {
                cur = cur.next;
            }
            if (cur == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = cur.next;
            cur.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            cur = start;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

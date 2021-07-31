package codeoffer;

import base.ListNode;

/**
 * @author: CyS2020
 * @date: 2021/5/14
 * 描述：反转链表
 * 思路：null <- 1 <- 2   3 -> 4 -> 5
 * pre cur  next
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        for (ListNode cur = head; cur != null; cur = next) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }
}

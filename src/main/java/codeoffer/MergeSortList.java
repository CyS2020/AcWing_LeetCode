package codeoffer;

import base.ListNode;

/**
 * @author: CyS2020
 * @date: 2021/5/16
 * 描述：合并有序链表
 * 思路：创建一个head备用，最后返回head.next
 */
public class MergeSortList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);

        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return head.next;
    }
}

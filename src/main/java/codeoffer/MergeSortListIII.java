package codeoffer;

import base.ListNode;

/**
 * @author: CyS2020
 * @date: 2021/9/19
 * 描述：排序链表
 * 思路：使用归并排序
 */
public class MergeSortListIII {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode left = sortList(head, mid);
        ListNode right = sortList(mid, tail);
        return new MergeSortList().mergeTwoLists(left, right);
    }
}

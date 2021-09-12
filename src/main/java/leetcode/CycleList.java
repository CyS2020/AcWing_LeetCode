package leetcode;

import base.ListNode;

/**
 * @author: CyS2020
 * @date: 2021/9/12
 * 描述：环形链表
 * 思路：快慢指针
 */
public class CycleList {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

package leetcode;

import base.ListNode;
import codeoffer.ReverseList;

/**
 * @author: CyS2020
 * @date: 2021/9/25
 * 描述：回文链表
 * 思路：快慢指针找中点; 偶数时修改while判断可以返回中线左边的或者中线右边的点
 * 之所以需要反转是因为需要在O(1)的空间复杂度, 并且需要还原之前的链表
 */
public class ListPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode firstEnd = slow;
        ListNode secondFirst = slow.next;
        ReverseList reverse = new ReverseList();
        secondFirst = reverse.reverseList(secondFirst);
        ListNode l1 = head;
        ListNode l2 = secondFirst;
        boolean res = true;
        while (res && l2 != null) {
            if (l1.val != l2.val) {
                res = false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        firstEnd.next = reverse.reverseList(secondFirst);
        return res;
    }
}

package codeoffer;

import base.ListNode;

/**
 * @author: CyS2020
 * @date: 2021/7/4
 * 描述：两个链表的第一个公共节点
 * 思路：两个节点，分别把两个链表都走一遍，直到节点相等
 */
public class CommonListNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }
}

package leetcode;

import base.ListNode;

/**
 * @author: CyS2020
 * @date: 2021/9/19
 * 描述：相交链表
 * 思路：类似于环形链表的思路 找到路径相等的等式
 * 相交的情况：x + y + z = z + y + x
 *           x
 *        ......   y
 *    z         ......
 *  ............
 * 不相交的情况：x + z = z + x
 */
public class CycleListIII {

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

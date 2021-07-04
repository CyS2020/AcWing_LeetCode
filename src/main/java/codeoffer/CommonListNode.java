package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/7/4
 * 描述：两个链表的第一个公共节点
 * 思路：两个节点，分别把两个链表都走一遍，直到节点相等
 */
public class CommonListNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            if (curA == null) {
                curA = headB;
            } else {
                curA = curA.next;
            }
            if (curB == null) {
                curB = headA;
            } else {
                curB = curB.next;
            }
        }
        return curA;
    }
}

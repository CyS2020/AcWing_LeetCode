package base;

/**
 * @author: CyS2020
 * @date: 2021/5/13
 * 描述：链表节点
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

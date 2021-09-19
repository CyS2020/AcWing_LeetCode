package leetcode;

import base.ListNode;

/**
 * @author: CyS2020
 * @date: 2021/9/19
 * 描述：环形链表II
 * 思路：在相遇点路径划分段：快指针 = x + y + z + y, 慢指针 = x + y
 * 由于快指针速度是慢指针的两倍 => x + y + z + y = 2 * (x + y) 整理得：x = z
 * 因此在相遇后重置起点第二次相遇就是环的起点位置(O为两次相遇的点)
 *      x
 * .......... O
 *         .     .
 *     z .        . y
 *        .      .
 *          O  .
 */
public class CycleListII {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}

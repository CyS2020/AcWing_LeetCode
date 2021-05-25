package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/24
 * 描述：复杂链表的复制
 * 思路：先复制到后面，在拆分出来
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        // 复制链表
        for (Node cur = head; cur != null; cur = cur.next) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next;
        }
        // 复制Random指针
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next;
        }
        // 还原链表
        Node dummy = new Node(0);
        Node d = dummy;
        for (Node cur = head; cur != null; cur = cur.next) {
            d.next = cur.next;
            d = d.next;
            cur.next = cur.next.next;
        }
        return dummy.next;
    }

    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }
}

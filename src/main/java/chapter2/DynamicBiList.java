package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/3/17
 * 描述：双向链表
 * 口诀：先找儿子后找爹，全局边界初为null，边界增删特处理，游标从0k-1
 */
public class DynamicBiList {

    private static Node head = new Node(0, 0);

    private static Node tail = new Node(0, 0);

    static {
        head.next = tail;
        tail.prev = head;
    }

    public static int index = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            String[] arr = line.split(" ");
            switch (arr[0]) {
                case "L":
                    addToHead(Integer.parseInt(arr[1]));
                    index++;
                    break;
                case "R":
                    addToTail(Integer.parseInt(arr[1]));
                    index++;
                    break;
                case "D":
                    deleteKth(Integer.parseInt(arr[1]));
                    break;
                case "IL":
                    addToKthLeft(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                    index++;
                    break;
                case "IR":
                    addToKthRight(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                    index++;
                    break;
            }
        }
        for (Node cur = head.next; cur != tail; cur = cur.next) {
            System.out.print(cur.value + " ");
        }
    }

    public static void addToHead(int value) {
        Node newNode = new Node(value, index);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    public static void addToTail(int value) {
        Node newNode = new Node(value, index);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public static void deleteKth(int k) {
        Node cur = head;
        while (cur.index != k) {
            cur = cur.next;
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }

    public static void addToKthLeft(int k, int value) {
        Node cur = tail;
        while (cur.index != k) {
            cur = cur.prev;
        }
        Node newNode = new Node(value, index);
        newNode.next = cur;
        newNode.prev = cur.prev;
        cur.prev.next = newNode;
        cur.prev = newNode;
    }

    public static void addToKthRight(int k, int value) {
        Node cur = head;
        while (cur.index != k) {
            cur = cur.next;
        }
        Node newNode = new Node(value, index);
        newNode.next = cur.next;
        newNode.prev = cur;
        cur.next.prev = newNode;
        cur.next = newNode;
    }

    public static class Node {
        int value;
        int index;
        Node prev;
        Node next;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}

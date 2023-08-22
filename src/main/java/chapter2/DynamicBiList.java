package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/3/17
 * 描述：双向链表
 * 口诀：添加时先右后左
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
        Node node = new Node(value, index);
        Node next = head.next;
        node.next = next;
        next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public static void addToTail(int value) {
        Node node = new Node(value, index);
        Node prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        prev.next = node;
        node.prev = prev;
    }

    public static void deleteKth(int k) {
        Node cur = head;
        while (cur.index != k) {
            cur = cur.next;
        }
        Node prev = cur.prev;
        Node next = cur.next;
        prev.next = next;
        next.prev = prev;
    }

    public static void addToKthLeft(int k, int value) {
        Node cur = head;
        while (cur.index != k) {
            cur = cur.next;
        }
        Node node = new Node(value, index);
        Node left = cur.prev;
        node.next = cur;
        cur.prev = node;
        left.next = node;
        node.prev = left;
    }

    public static void addToKthRight(int k, int value) {
        Node cur = head;
        while (cur.index != k) {
            cur = cur.next;
        }
        Node node = new Node(value, index);
        Node right = cur.next;
        node.next = right;
        right.prev = node;
        cur.next = node;
        node.prev = cur;
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

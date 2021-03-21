package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/3/17
 * 描述：双向链表
 */
public class DynamicBiList {

    public static Node head = null;

    public static Node tail = null;

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
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur + " ");
        }
    }

    public static void addToHead(int value) {
        Node newNode = new Node(value, index);
        Node tmp = head;
        newNode.next = head;
        head = newNode;
        if (tmp == null) {
            tail = newNode;
        } else {
            tmp.prev = newNode;
        }
    }

    public static void addToTail(int value) {
        Node newNode = new Node(value, index);
        Node tmp = tail;
        newNode.prev = tail;
        tail = newNode;
        if (tmp == null) {
            head = newNode;
        } else {
            tmp.next = newNode;
        }
    }

    public static void deleteKth(int k) {
        Node cur = head;
        while (cur.index != k) {
            cur = cur.next;
        }
        Node next = cur.next;
        Node prev = cur.prev;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }
    }

    public static void addToKthLeft(int k, int value) {
        Node cur = tail;
        while (cur.index != k) {
            cur = cur.prev;
        }
        Node newNode = new Node(value, index);
        if (cur.prev == null) {
            addToHead(value);
            return;
        }
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
        if (cur.next == null) {
            addToTail(value);
            return;
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

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}

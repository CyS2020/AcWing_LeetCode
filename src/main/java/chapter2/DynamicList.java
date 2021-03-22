package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/3/16
 * 描述：动态单链表
 * 口诀：先找儿子后找爹，全局边界初为null，边界增删特处理，游标从0k-1
 */
public class DynamicList {

    public static int index = 1;

    public static Node head = null;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            String[] arr = line.split(" ");
            switch (arr[0]) {
                case "H":
                    addToHead(Integer.parseInt(arr[1]));
                    index++;
                    break;
                case "I":
                    addToKth(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                    index++;
                    break;
                case "D":
                    deleteKth(Integer.parseInt(arr[1]));
                    break;
            }
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur + " ");
        }
    }

    public static void deleteKth(int k) {
        if (k == 0) {
            head = head.next;
            return;
        }
        Node cur = head;
        while (cur.index != k) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }

    public static void addToKth(int k, int value) {
        Node cur = head;
        while (cur.index != k) {
            cur = cur.next;
        }
        Node newNode = new Node(value, index);
        newNode.next = cur.next;
        cur.next = newNode;
    }

    public static void addToHead(int value) {
        Node newNode = new Node(value, index);
        newNode.next = head;
        head = newNode;
    }

    public static class Node {
        int value;
        int index;
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

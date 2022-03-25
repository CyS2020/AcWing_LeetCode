package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/4/3
 * 描述：哈希表
 * 口诀：拉链法
 */
public class HashZipper {

    private final int n;

    private final Node[] table;

    public HashZipper(int n) {
        this.n = n;
        this.table = new Node[n];
    }

    public void insert(int x) {
        // 兼容负数
        int k = (x % n + n) % n;
        Node head = table[k];
        Node node = new Node(x);
        node.next = head;
        table[k] = node;
    }

    public boolean query(int x) {
        int k = (x % n + n) % n;
        for (Node cur = table[k]; cur != null; cur = cur.next) {
            if (cur.value == x) {
                return true;
            }
        }
        return false;
    }

    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        HashZipper hash = new HashZipper(n);
        while ((line = input.readLine()) != null) {
            String[] arr = line.split(" ");
            String op = arr[0];
            int x = Integer.parseInt(arr[1]);
            switch (op) {
                case "I":
                    hash.insert(x);
                    break;
                case "Q":
                    boolean b = hash.query(x);
                    System.out.println(b ? "Yes" : "No");
                    break;
            }
        }
    }
}

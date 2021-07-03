package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/3/28
 * 描述：Tire树
 * 口诀：没有条件创造条件也要上
 */

class Trie {

    public static Node root = new Node('0', 0);

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            String[] arr = line.split(" ");
            String opera = arr[0];
            String text = arr[1];
            switch (opera) {
                case "I":
                    insert(text);
                    break;
                case "Q":
                    int count = query(text);
                    System.out.println(count);
                    break;
            }
        }
    }

    public static void insert(String text) {
        Node cur = root;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (cur.next[ch - 'a'] == null) {
                cur.next[ch - 'a'] = new Node(ch, 0);
            }
            cur = cur.next[ch - 'a'];
        }
        cur.count++;
    }

    public static int query(String text) {
        Node cur = root;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (cur.next[ch - 'a'] == null) {
                return 0;
            }
            cur = cur.next[ch - 'a'];
        }
        return cur.count;
    }

    public static class Node {
        char ch;
        int count;
        Node[] next = new Node[26];

        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}

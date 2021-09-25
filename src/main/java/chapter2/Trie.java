package chapter2;

import base.TrieNode;

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

    public TrieNode root = new TrieNode('0', 0);

    public static void main(String[] args) throws IOException {
        Trie trie = new Trie();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            String[] arr = line.split(" ");
            String opera = arr[0];
            String text = arr[1];
            switch (opera) {
                case "I":
                    trie.insert(text);
                    break;
                case "Q":
                    int count = trie.query(text);
                    System.out.println(count);
                    break;
                case "P":
                    System.out.println(trie.startsWith(text));
            }
        }
    }

    public void insert(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char ch : chs) {
            int index = ch - 'a';
            if (cur.next[index] == null) {
                cur.next[index] = new TrieNode(ch, 0);
            }
            cur = cur.next[index];
        }
        cur.count++;
    }

    public int query(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char ch : chs) {
            int index = ch - 'a';
            if (cur.next[index] == null) {
                return 0;
            }
            cur = cur.next[index];
        }
        return cur.count;
    }

    public boolean startsWith(String prefix) {
        char[] chs = prefix.toCharArray();
        TrieNode cur = root;
        for (char ch : chs) {
            int index = ch - 'a';
            if (cur.next[index] == null) {
                return false;
            }
            cur = cur.next[index];
        }
        return cur != null;
    }
}

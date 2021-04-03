package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/3
 * 描述：最大异或对
 * 口诀：没有条件创造条件也要上
 */
class LargestXOR {

    public static Node root = new Node(0);

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 0;
        for (int i = 0; i < n; i++) {
            Insert(arr[i]);
            int res = query(arr[i]);
            max = Math.max(max, res ^ arr[i]);
        }
        System.out.println(max);
    }

    public static void Insert(int v) {
        Node cur = root;
        for (int i = 31; i >= 0; i--) {
            int bit = v >> i & 1;
            if (cur.next[bit] == null) {
                cur.next[bit] = new Node(bit << i);
            }
            cur = cur.next[bit];
        }
    }

    public static int query(int v) {
        Node cur = root;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = v >> i & 1;
            int rebit = bit == 0 ? 1 : 0;
            if (cur.next[rebit] != null) {
                cur = cur.next[rebit];
            } else {
                cur = cur.next[bit];
            }
            res += cur.value;
        }
        return res;
    }

    public static class Node {
        int value;
        Node[] next = new Node[2];

        public Node(int value) {
            this.value = value;
        }
    }
}

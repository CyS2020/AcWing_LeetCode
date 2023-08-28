package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/8
 * 描述：最大匹配
 * 口诀：匈牙利算法
 */
public class MaxMatch {

    public static int n1;

    public static int n2;

    public static Node[] heads;

    public static int res;

    public static int[] boyfriend;

    public static boolean[] st;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n1 = arr[0];
        n2 = arr[1];
        heads = new Node[n1 + 1];
        st = new boolean[n2 + 1];
        boyfriend = new int[n2 + 1];
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            addEdge(a, b);
        }

        for (int i = 1; i <= n1; i++) {
            Arrays.fill(st, false);
            if (findGirl(i)) {
                res++;
            }
        }
        System.out.println(res);
    }

    public static boolean findGirl(int u) {
        for (Node cur = heads[u]; cur != null; cur = cur.next) {
            int girl = cur.dst;
            if (!st[girl]) {
                st[girl] = true;
                if (boyfriend[girl] == 0 || findGirl(boyfriend[girl])) {
                    boyfriend[girl] = u;
                    return true;
                }
            }
        }
        return false;
    }

    public static void addEdge(int a, int b) {
        Node node = new Node(b);
        node.next = heads[a];
        heads[a] = node;
    }

    public static class Node {
        int dst;
        Node next;

        public Node(int dst) {
            this.dst = dst;
        }
    }
}

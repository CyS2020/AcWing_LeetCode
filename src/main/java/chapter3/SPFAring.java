package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/4/7
 * 描述：负环
 */
public class SPFAring {

    public static int n;

    public static Node[] heads;

    public static boolean[] st;

    public static int[] dist;

    public static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        heads = new Node[n + 1];
        st = new boolean[n + 1];
        dist = new int[n + 1];
        count = new int[n + 1];
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int w = arr[2];
            addEdge(a, b, w);
        }

        boolean ring = haveNegativeRing();
        System.out.println(ring ? "Yes" : "No");
    }

    public static boolean haveNegativeRing() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
            st[i] = true;
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            st[t] = false;
            for (Node cur = heads[t]; cur != null; cur = cur.next) {
                int v = cur.dst;
                if (dist[t] + cur.weight < dist[v]) {
                    dist[v] = dist[t] + cur.weight;
                    count[v] = count[t] + 1;
                    if (count[v] >= n) {
                        return true;
                    }
                    if (!st[v]) {
                        queue.add(v);
                        st[v] = true;
                    }
                }
            }
        }

        return false;
    }

    public static void addEdge(int a, int b, int w) {
        Node node = new Node(b, w);
        node.next = heads[a];
        heads[a] = node;
    }


    public static class Node {
        int dst;
        int weight;
        Node next;

        public Node(int dst, int weight) {
            this.dst = dst;
            this.weight = weight;
        }
    }
}

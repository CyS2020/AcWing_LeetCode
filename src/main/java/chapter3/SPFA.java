package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/4/6
 * 描述：spfa算法
 * 口诀：确保不能存在负环
 */
public class SPFA {

    public static int n;

    public static Node[] heads;

    public static int[] dist;

    public static boolean[] st;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        heads = new Node[n + 1];
        dist = new int[n + 1];
        st = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int w = arr[2];
            addEdge(a, b, w);
        }

        int distance = calcShortestPath(1, n);
        System.out.println(distance == -1 ? "impossible" : distance);
    }

    public static int calcShortestPath(int src, int dst) {
        Queue<Integer> queue = new LinkedList<>();
        dist[src] = 0;
        queue.add(src);
        st[src] = true;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            st[t] = false;
            for (Node cur = heads[t]; cur != null; cur = cur.next) {
                int v = cur.dst;
                if (dist[t] + cur.weight < dist[v]) {
                    dist[v] = dist[t] + cur.weight;
                    if (!st[v]) {
                        queue.add(v);
                        st[v] = true;
                    }
                }
            }
        }

        return dist[dst] > Integer.MAX_VALUE / 4 ? -1 : dist[dst];
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
            this.weight = weight;
            this.dst = dst;
        }
    }
}

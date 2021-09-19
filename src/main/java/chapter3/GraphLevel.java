package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/4/5
 * 描述：图的层次
 * 口诀：权值均为1的图求最短路径
 */
public class GraphLevel {

    public static Node[] heads;

    public static int[] dist;

    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        heads = new Node[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            addEdge(arr[0], arr[1]);
        }
        int dist = bfs(1);
        System.out.println(dist);
    }

    public static int bfs(int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        dist[u] = 0;
        while (!queue.isEmpty()) {
            int src = queue.poll();
            if (src == n) {
                return dist[src];
            }
            for (Node cur = heads[src]; cur != null; cur = cur.next) {
                int dst = cur.value;
                if (dist[dst] == -1) {
                    queue.add(dst);
                    dist[dst] = dist[src] + 1;
                }
            }
        }
        return -1;
    }

    public static void addEdge(int a, int b) {
        Node node = new Node(b);
        node.next = heads[a];
        heads[a] = node;
    }

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

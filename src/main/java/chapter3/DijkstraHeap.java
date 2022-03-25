package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/4/6
 * 描述：堆优化Dijkstra
 * 口诀：优先队列有冗余
 * 队列queue可以更新旧值(contains-remove-add), 就可以省略st数组, 不过性能会变差
 */
public class DijkstraHeap {

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
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int w = arr[2];
            addEdge(a, b, w);
        }

        int distance = calcShortestPath(1, n);
        System.out.println(distance);
    }

    private static int calcShortestPath(int src, int dst) {
        Queue<Integer> queue = new PriorityQueue<>(DijkstraHeap::compareTo);
        queue.add(src);
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int t = queue.poll();
            if (st[t]) {
                continue;
            }
            if (t == dst) {
                break;
            }
            st[t] = true;
            for (Node cur = heads[t]; cur != null; cur = cur.next) {
                int v = cur.dst;
                if (dist[t] + cur.weight < dist[v]) {
                    dist[v] = dist[t] + cur.weight;
                    queue.add(v);
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE / 2 ? -1 : dist[dst];
    }

    public static int compareTo(int a, int b) {
        return dist[a] - dist[b];
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

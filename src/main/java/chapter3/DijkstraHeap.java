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
        st = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            addEdge(arr[0], arr[1], arr[2]);
        }

        int distance = calcShortestPath(1, n);
        System.out.println(distance);
    }

    private static int calcShortestPath(int src, int dst) {
        Queue<Pair> queue = new PriorityQueue<>();
        dist[src] = 0;
        queue.add(new Pair(src, dist[src]));

        while (!queue.isEmpty()) {
            int head = queue.poll().dst;
            if (head == dst) {
                return dist[dst];
            }
            if (!st[head]) {
                st[head] = true;
                for (Node cur = heads[head]; cur != null; cur = cur.next) {
                    int next = cur.dst;
                    if (dist[next] > dist[head] + cur.weight) {
                        dist[next] = dist[head] + cur.weight;
                        queue.add(new Pair(next, dist[next]));
                    }
                }
            }
        }
        return -1;
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

    public static class Pair implements Comparable<Pair> {
        int dst;
        int dist;

        public Pair(int dst, int dist) {
            this.dst = dst;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair o) {
            return dist - o.dist;
        }
    }
}

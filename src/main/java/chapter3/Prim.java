package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/4/7
 * 描述：最小生成树
 * 口诀：更新到连通块的距离
 * Dijkstra 队头的点表示，已经找到到该点的最短距离了
 * Prim 队头的点表示，已经找到包含该点的最小生成树了
 */
public class Prim {

    public static int n;

    public static boolean[] st;

    public static Node[] heads;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        st = new boolean[n + 1];
        heads = new Node[n + 1];
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            addEdge(arr[0], arr[1], arr[2]);
            addEdge(arr[1], arr[0], arr[2]);
        }

        String weights = calcMinTree();
        System.out.println(weights);
    }

    public static String calcMinTree() {
        Queue<Pair> queue = new PriorityQueue<>();
        int weights = 0;
        int count = 0;
        queue.add(new Pair(1, 0));

        while (!queue.isEmpty()) {
            Pair head = queue.poll();
            if (!st[head.dst]) {
                weights += head.dist;
                st[head.dst] = true;
                count++;
                for (Node cur = heads[head.dst]; cur != null; cur = cur.next) {
                    int next = cur.dst;
                    queue.add(new Pair(next, cur.weight));
                }
            }
        }
        return count == n ? String.valueOf(weights) : "impossible";
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

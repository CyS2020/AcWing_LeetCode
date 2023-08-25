package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/6
 * 描述：贝尔曼-福特算法
 * 口诀：使用备份更新距离
 */
public class BellmanFord {

    public static int n, k;

    public static Node[] heads;

    public static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        k = arr[2];
        heads = new Node[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            addEdge(arr[0], arr[1], arr[2]);
        }

        String distance = calcShortestPath(1, n);
        System.out.println(distance);
    }

    private static String calcShortestPath(int src, int dst) {
        dist[src] = 0;
        int[] backup = new int[n + 1];
        for (int i = 0; i < k; i++) {
            System.arraycopy(dist, 0, backup, 0, n + 1);
            for (int j = 0; j <= n; j++) {
                for (Node cur = heads[j]; cur != null; cur = cur.next) {
                    int next = cur.dst;
                    if (dist[next] > backup[j] + cur.weight) {
                        dist[next] = backup[j] + cur.weight;
                    }
                }
            }
        }
        return dist[dst] >= Integer.MAX_VALUE / 4 ? "impossible" : String.valueOf(dist[dst]);
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

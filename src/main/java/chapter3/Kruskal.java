package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/4/7
 * 描述：克鲁斯卡尔
 */
public class Kruskal {

    public static int n;

    public static int[] parent;

    public static List<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        edges = new ArrayList<>();
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(new Edge(arr[0], arr[1], arr[2]));
        }
        String weights = calcMinTree();
        System.out.println(weights);
    }

    private static String calcMinTree() {
        Collections.sort(edges);
        int weights = 0;
        int count = 1;
        for (Edge edge : edges) {
            int src = edge.src;
            int dst = edge.dst;
            if (find(src) != find(dst)) {
                count++;
                weights += edge.weight;
                merge(src, dst);
            }
        }
        return count == n ? String.valueOf(weights) : "impossible";
    }

    private static void merge(int src, int dst) {
        parent[find(src)] = parent[find(dst)];
    }

    private static int find(int src) {
        if (parent[src] != src) {
            parent[src] = find(parent[src]);
        }
        return parent[src];
    }

    public static class Edge implements Comparable<Edge> {
        int src;
        int dst;
        int weight;

        public Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}

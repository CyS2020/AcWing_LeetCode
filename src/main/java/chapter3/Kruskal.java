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

    public static int[] ancestor;

    public static List<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        ancestor = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ancestor[i] = i;
        }
        edges = new ArrayList<>();
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int w = arr[2];
            edges.add(new Edge(a, b, w));
            //edges.add(new Edge(b, a, w));
        }
        int weights = calcMinTree();
        System.out.println(weights == -1 ? "impossible" : weights);
    }

    public static int calcMinTree() {
        Collections.sort(edges);
        int weights = 0;
        int count = 0;
        for (Edge edge : edges) {
            int a = edge.src;
            int b = edge.dst;
            int w = edge.weight;
            if (find(a) != find(b)) {
                weights += w;
                count++;
                merge(a, b);
            }
        }
        return count < n - 1 ? -1 : weights;
    }

    public static void merge(int a, int b) {
        ancestor[find(a)] = find(b);
    }

    public static int find(int a) {
        if (ancestor[a] != a) {
            ancestor[a] = find(ancestor[a]);
        }
        return ancestor[a];
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
            return this.weight - o.weight;
        }
    }
}

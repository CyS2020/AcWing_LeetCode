package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/4/5
 * 描述：拓扑排序
 * 口诀：入度为0则无敌
 */
public class SortTopology {

    public static int n, m;

    public static Node[] heads;

    public static int[] degree;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        heads = new Node[n + 1];
        degree = new int[n + 1];

        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            addEdge(arr[0], arr[1]);
        }

        List<Integer> topo = sort();
        if (topo.size() == n) {
            topo.forEach(v -> System.out.print(v + " "));
        } else {
            System.out.println("-1");
        }
    }

    public static List<Integer> sort() {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> keep = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                keep.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int src = queue.poll();
            for (Node cur = heads[src]; cur != null; cur = cur.next) {
                int dst = cur.value;
                if (--degree[dst] == 0) {
                    queue.add(dst);
                    keep.add(dst);
                }
            }
        }
        return keep;
    }

    public static void addEdge(int a, int b) {
        Node node = new Node(b);
        node.next = heads[a];
        heads[a] = node;
        degree[b]++;
    }

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

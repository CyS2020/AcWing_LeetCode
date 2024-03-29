package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/7
 * 描述：二分图
 * 口诀：染色法
 */
public class BinaryPicture {

    public static Node[] heads;

    public static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        heads = new Node[n + 1];
        color = new int[n + 1];
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            addEdge(a, b);
            addEdge(b, a);
        }

        boolean isBinary = true;
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    isBinary = false;
                    break;
                }
            }
        }
        System.out.println(isBinary ? "Yes" : "No");
    }

    public static boolean dfs(int u, int c) {
        color[u] = c;
        for (Node cur = heads[u]; cur != null; cur = cur.next) {
            if (color[cur.dst] == 0) {
                if (!dfs(cur.dst, 3 - c)) {
                    return false;
                }
            } else if (color[cur.dst] == c) {
                return false;
            }
        }
        return true;
    }

    public static void addEdge(int a, int b) {
        Node node = new Node(b);
        node.next = heads[a];
        heads[a] = node;
    }

    public static class Node {
        int dst;
        Node next;

        public Node(int dst) {
            this.dst = dst;
        }
    }
}

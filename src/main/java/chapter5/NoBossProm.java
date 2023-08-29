package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/27
 * 描述：没有上司的舞会
 */
public class NoBossProm {

    public static int[][] f;

    public static int[] happy;

    public static Node[] heads;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line);

        f = new int[N + 1][2];
        happy = new int[N + 1];
        heads = new Node[N + 1];
        boolean[] st = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            line = input.readLine();
            happy[i] = Integer.parseInt(line);
        }
        for (int i = 1; i <= N - 1; i++) {
            line = input.readLine();
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[1];
            int b = arr[0];
            addEdge(a, b);
            st[b] = true;
        }
        // 寻找根节点
        int u = 0;
        for (int i = 1; i <= N; i++) {
            if (!st[i]) {
                u = i;
                break;
            }
        }

        calcMaxHappy(u);
        System.out.println(Math.max(f[u][1], f[u][0]));

    }

    private static void calcMaxHappy(int u) {
        f[u][1] = happy[u];
        for (Node cur = heads[u]; cur != null; cur = cur.next) {
            calcMaxHappy(cur.value);
            f[u][1] += f[cur.value][0];
            f[u][0] += Math.max(f[cur.value][0], f[cur.value][1]);
        }
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

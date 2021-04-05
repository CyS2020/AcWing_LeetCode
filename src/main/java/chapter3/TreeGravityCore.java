package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/5
 * 描述：树的重心
 * 口诀：终止条件+恢复现场
 */
public class TreeGravityCore {

    public static int n;

    public static Node[] heads;

    public static boolean[] st;

    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        n = Integer.parseInt(line);
        heads = new Node[n + 1];
        st = new boolean[n + 1];
        while ((line = input.readLine()) != null) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            addEdge(arr[0], arr[1]);
            addEdge(arr[1], arr[0]);
        }
        dfs(1);
        System.out.println(ans);
    }

    // 返回以u为根节点(包含u)的节点数
    public static int dfs(int u) {
        int sum = 0;
        int res = 0;
        for (Node cur = heads[u]; cur != null; cur = cur.next) {
            if (!st[cur.value]) {
                st[cur.value] = true;
                int union = dfs(cur.value);
                res = Math.max(res, union);
                sum += union;
            }
        }
        res = Math.max(res, n - sum - 1);
        ans = Math.min(ans, res);
        return sum + 1;
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

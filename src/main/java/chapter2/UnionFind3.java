package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/3
 * 描述：食物链
 * 口诀：递归更新父节点，find三行最核心
 */
public class UnionFind3 {

    public static int[] ancestor;

    public static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];
        int res = 0;
        ancestor = new int[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ancestor[i] = i;
        }
        while (m-- > 0) {
            line = input.readLine();
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int st = arr[0];
            int x = arr[1];
            int y = arr[2];
            if (x > n || y > n) {
                res++;
                continue;
            }
            int fx = find(x);
            int fy = find(y);
            if (st == 1 && fx == fy && (dist[y] - dist[x]) % 3 != 0) {
                res++;
            }
            if (st == 2 && fx == fy && (dist[y] - dist[x] + 1) % 3 != 0) {
                res++;
            }
            if (fx != fy) {
                merge(x, y, st);
            }
        }
        System.out.println(res);
    }

    public static void merge(int x, int y, int st) {
        int fx = find(x);
        int fy = find(y);
        ancestor[fx] = fy;
        if (st == 1) {
            dist[fx] = dist[y] - dist[x];
        }
        if (st == 2) {
            dist[fx] = dist[y] - dist[x] + 1;
        }
    }

    public static int find(int x) {
        if (x != ancestor[x]) {
            int u = find(ancestor[x]);
            dist[x] += dist[ancestor[x]];
            ancestor[x] = u;
        }
        return ancestor[x];
    }

}

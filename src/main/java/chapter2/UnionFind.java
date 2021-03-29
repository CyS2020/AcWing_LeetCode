package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/3/29
 * 描述：并查集
 * 口诀：递归更新父节点，find函数最核心
 */
public class UnionFind {

    public static int[] father = new int[100010];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
        while ((line = input.readLine()) != null) {
            String[] arr = line.split(" ");
            int a = Integer.parseInt(arr[1]);
            int b = Integer.parseInt(arr[2]);
            switch (arr[0]) {
                case "M":
                    merge(a, b);
                    break;
                case "Q":
                    boolean isSame = query(a, b);
                    System.out.println(isSame ? "Yes" : "No");

            }
        }
    }

    public static void merge(int a, int b) {
        if (find(a) != find(b)) {
            father[find(a)] = find(b);
        }
    }

    public static boolean query(int a, int b) {
        return find(a) == find(b);
    }

    public static int find(int a) {
        if (father[a] != a) {
            father[a] = find(father[a]);
        }
        return father[a];
    }
}

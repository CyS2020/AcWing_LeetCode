package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/3/29
 * 描述：连通块数量
 * 口诀：size的更新要在merge之前进行
 */
public class UnionFind2 {

    public static int[] parent;

    public static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        while ((line = input.readLine()) != null) {
            String[] arr = line.split(" ");
            int a = Integer.parseInt(arr[1]);
            int b = arr.length == 3 ? Integer.parseInt(arr[2]) : 0;
            switch (arr[0]) {
                case "C":
                    merge(a, b);
                    break;
                case "Q1":
                    boolean isSame = find(a) == find(b);
                    System.out.println(isSame ? "Yes" : "No");
                    break;
                case "Q2":
                    int count = count(a);
                    System.out.println(count);
                    break;

            }
        }
    }

    public static void merge(int a, int b) {
        if (find(a) != find(b)) {
            size[find(b)] += size[find(a)];
            parent[find(a)] = parent[find(b)];
        }
    }

    public static int count(int a) {
        return size[find(a)];
    }

    // 路径压缩
    public static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}

package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/30
 * 描述：堆排序
 * 口诀：下沉三角取最小，上浮两者来比较
 */
public class SortHeap {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0] - 1;
        int m = arr[1];
        line = input.readLine();
        arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = n / 2; i >= 0; i--) {
            down(arr, i, n);
        }
        for (int i = 0; i < m; i++) {
            System.out.print(arr[0] + " ");
            swap(arr, 0, n--);
            down(arr, 0, n);
        }
    }

    public static void down(int[] arr, int u, int n) {
        if (u >= n) {
            return;
        }
        int t = u;
        if (2 * u + 1 <= n && arr[2 * u + 1] < arr[t]) {
            t = 2 * u + 1;
        }
        if (2 * u + 2 <= n && arr[2 * u + 2] < arr[t]) {
            t = 2 * u + 2;
        }
        if (t != u) {
            swap(arr, u, t);
            down(arr, t, n);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

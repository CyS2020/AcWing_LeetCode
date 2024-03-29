package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/1
 * 描述：快速排序
 * 口诀：确定中间分界点，左右指针往外扩，左小右大移指针，递归处理左和右
 * mid 是一直变化的，因此 while 比较时不能使用 q[mid]
 */

class SortQuick {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        line = input.readLine();
        int[] q = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        quickSort(q, 0, n - 1);
        Arrays.stream(q).forEach(k -> System.out.print(k + " "));
    }

    public static void quickSort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = q[l + r >> 1];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            while (q[++i] < mid) ;
            while (mid < q[--j]) ;
            if (i < j) {
                swap(q, i, j);
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }

    public static void swap(int[] q, int i, int j) {
        int tmp = q[i];
        q[i] = q[j];
        q[j] = tmp;
    }
}

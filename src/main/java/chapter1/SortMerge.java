package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/2
 * 描述：归并排序
 * 口诀：口诀：确定中间分界点，递归处理左和右，tmp数组归并：while 交替 + 左右单向
 */
public class SortMerge {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        line = input.readLine();
        int[] q = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        mergeSort(q, 0, n - 1);
        Arrays.stream(q).forEach(k -> System.out.print(k + " "));
    }

    public static void mergeSort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + r >> 1;
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);
        int[] tmp = new int[r - l + 1];
        int k = 0;
        int i = l;
        int j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {
                tmp[k++] = q[i++];
            } else {
                tmp[k++] = q[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = q[i++];
        }
        while (j <= r) {
            tmp[k++] = q[j++];
        }
        for (k = 0, i = l; i <= r; k++, i++) {
            q[i] = tmp[k];
        }
    }
}

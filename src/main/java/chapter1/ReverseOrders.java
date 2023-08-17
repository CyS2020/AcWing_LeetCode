package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/10
 * 描述：逆序对数量
 * 口诀：归并排序 + 前半边比后半边大的个数
 * 当左边，右边分别是有序的时候
 * 如果一个数从右边先归到左边 i 处，那么该值肯定比 i ~ mid 段都小，那么 i ~ mid 段都是逆序的
 */
public class ReverseOrders {

    public static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        line = input.readLine();
        int[] q = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        mergeSort(q, 0, n - 1);
        System.out.println(count);
    }

    public static void mergeSort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + r >> 1;
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);
        int[] tmp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {
                tmp[k++] = q[i++];
            } else {
                tmp[k++] = q[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) {
            tmp[k++] = q[i++];
        }
        while (j <= r) {
            tmp[k++] = q[j++];
        }
        for (i = l, k = 0; i <= r; i++, k++) {
            q[i] = tmp[k];
        }
    }
}

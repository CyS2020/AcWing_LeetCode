import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/9
 * 描述：第k个数
 * 口诀：快速排序与分治
 */
public class AcWing1_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int k = arr[1];
        line = input.readLine();
        int[] q = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = findKth(q, 0, n - 1, k - 1);
        System.out.println(result);
    }

    public static int findKth(int[] q, int l, int r, int k) {
        if (l == r) {
            return q[r];
        }
        int x = q[l + r >> 1];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) {
                swap(q, i, j);
            }
        }
        if (k <= j) {
            return findKth(q, l, j, k);
        }
        return findKth(q, j + 1, r, k);
    }

    public static void swap(int[] q, int i, int j) {
        int tmp = q[i];
        q[i] = q[j];
        q[j] = tmp;
    }
}

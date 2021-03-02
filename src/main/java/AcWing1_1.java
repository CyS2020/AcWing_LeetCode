import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/1
 * 描述：快速排序
 * 口诀：确定中间分界点，左右指针往外扩，左小右大移指针，递归处理左和右
 */

class AcWing1_1 {

    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = input.readLine();
            int n = Integer.parseInt(line);
            line = input.readLine();
            int[] q = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            quick_sort(q, 0, n - 1);
            Arrays.stream(q).forEach(k -> System.out.print(k + " "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void quick_sort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }
        int a = q[l + r >> 1];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            while (q[++i] < a) ;
            while (q[--j] > a) ;
            if (i < j) {
                swap(q, i, j);
            }
        }
        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);
    }

    public static void swap(int[] q, int i, int j) {
        int tmp = q[i];
        q[i] = q[j];
        q[j] = tmp;
    }
}

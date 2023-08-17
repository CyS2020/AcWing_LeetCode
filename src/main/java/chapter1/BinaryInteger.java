package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/3
 * 描述：整数二分
 * 口诀：左段取左，右段取右，左段+1
 * 0 1 x_ x x- 9, x_ 满足的条件是右段 x_ <= q[mid]; x- 满足的条件是左段：q[mid] <= x-
 */
public class BinaryInteger {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        line = input.readLine();
        int[] q = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        while ((line = input.readLine()) != null) {
            int x = Integer.parseInt(line);
            int start = leftBound(q, x);
            int end = rightBound(q, x);
            System.out.println(start + " " + end);
        }
    }

    public static int leftBound(int[] q, int target) {
        int l = 0;
        int r = q.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (target <= q[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return q[r] == target ? r : -1;
    }

    public static int rightBound(int[] q, int target) {
        int l = 0;
        int r = q.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (q[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return q[r] == target ? r : -1;
    }
}

package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/3
 * 描述：整数二分
 * 口诀：左段左移，右段右移，左移+1
 */
public class BinarySearchInteger {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        line = input.readLine();
        int[] q = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        while ((line = input.readLine()) != null) {
            int x = Integer.parseInt(line);
            int start = binarySearchStart(q, x);
            int end = binarySearchEnd(q, x);
            System.out.println(start + " " + end);
        }
    }

    public static int binarySearchStart(int[] q, int x) {
        int l = 0;
        int r = q.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (q[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return q[r] == x ? r : -1;
    }

    public static int binarySearchEnd(int[] q, int x) {
        int l = 0;
        int r = q.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (q[mid] <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return q[r] == x ? r : -1;
    }
}

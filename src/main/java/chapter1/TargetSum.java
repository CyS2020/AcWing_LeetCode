package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/12
 * 描述：数组元素的目标和
 * 口诀：循环数组双指针，小i小j需check
 */
public class TargetSum {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = arr[2];
        line = input.readLine();
        int[] a = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        line = input.readLine();
        int[] b = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        Pair pair = findSumIndex(a, b, sum);
        System.out.println(pair);
    }

    public static Pair findSumIndex(int[] a, int[] b, int sum) {
        int i = 0;
        int j = b.length - 1;
        while (i < a.length && j >= 0) {
            if (a[i] + b[j] > sum) {
                j--;
            } else if (a[i] + b[j] < sum) {
                i++;
            } else {
                return new Pair(i, j);
            }
        }
        return new Pair(-1, -1);
    }

    static class Pair {
        public int i;
        public int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return i + " " + j;
        }
    }
}

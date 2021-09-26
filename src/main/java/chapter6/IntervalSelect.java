package chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/4/29
 * 描述：区间选点
 * 描述：最大不相交区间数量
 * 思路：与区间合并相反, 找出最多互不干涉的区间
 */
public class IntervalSelect {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line);
        List<Pair> intervals = new ArrayList<>();
        while ((line = input.readLine()) != null) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            intervals.add(new Pair(arr[0], arr[1]));
        }

        Collections.sort(intervals);

        int ed = Integer.MIN_VALUE;
        int res = 0;
        for (Pair pair : intervals) {
            if (ed < pair.left) {
                res++;
                ed = pair.right;
            }
        }
        System.out.println(res);
    }

    public static class Pair implements Comparable<Pair> {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.right - pair.right;
        }
    }
}

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
 * 描述：区间覆盖--请你选择尽量少的区间，将指定线段区间完全覆盖。
 */
public class IntervalCover {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int st = arr[0];
        int ed = arr[1];
        line = input.readLine();
        int N = Integer.parseInt(line);
        List<Pair> intervals = new ArrayList<>();
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            intervals.add(new Pair(arr[0], arr[1]));
        }

        Collections.sort(intervals);
        System.out.println(cover(st, ed, intervals));
    }

    public static int cover(int st, int ed, List<Pair> intervals) {
        if (st == ed) {
            for (Pair pair : intervals) {
                if (pair.left <= st && pair.right >= ed) {
                    return 1;
                }
            }
        }
        int res = 0;
        int i = 0;
        int cur = st;
        while (cur < ed) {
            while (i < intervals.size()) {
                Pair pair = intervals.get(i);
                if (pair.left <= st) {
                    cur = Math.max(cur, pair.right);
                } else {
                    break;
                }
                i++;
            }
            if (cur == st) {
                return -1;
            }
            st = cur;
            res++;
        }
        return res;
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
            return this.left - pair.left;
        }
    }
}

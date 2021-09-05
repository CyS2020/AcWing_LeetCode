package chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: CyS2020
 * @date: 2021/3/14
 * 描述：区间合并
 * 口诀：左右端点来排序，策略多数是贪心
 * merge方法寻找的是排序后的区间
 */
public class IntervalMerge {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        Set<Pair> interval = new TreeSet<>();
        while ((line = input.readLine()) != null) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            interval.add(new Pair(arr[0], arr[1]));
        }
        int count = 0;
        int ed = Integer.MIN_VALUE;
        for (Pair pair : interval) {
            int left = pair.left;
            int right = pair.right;
            if (ed < left) {
                count++;
            }
            ed = Math.max(ed, right);
        }
        System.out.println(count);
    }

    public int[][] merge(int[][] intervals) {
        List<Pair> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new Pair(interval[0], interval[1]));
        }
        Collections.sort(list);
        int st = list.get(0).left;
        int ed = list.get(0).right;
        List<Pair> resPair = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            Pair pair = list.get(i);
            if (ed < pair.left) {
                resPair.add(new Pair(st, ed));
                st = pair.left;
                ed = pair.right;
            } else {
                ed = Math.max(ed, pair.right);
            }
        }
        resPair.add(new Pair(st, ed));

        int[][] res = new int[resPair.size()][2];
        for (int i = 0; i < resPair.size(); i++) {
            Pair pair = resPair.get(i);
            res[i] = new int[]{pair.left, pair.right};
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
            if (this.left != pair.left) {
                return this.left < pair.left ? -1 : 1;
            }
            if (this.right != pair.right) {
                return this.right < pair.right ? -1 : 1;
            }
            return 0;
        }
    }
}

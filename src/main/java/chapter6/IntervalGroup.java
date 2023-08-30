package chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/4/29
 * 描述：区间分组--使得每组内部的区间两两之间（包括端点）没有交集，并使得组数尽可能小。
 */
public class IntervalGroup {

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

        Queue<Integer> queue = new PriorityQueue<>();
        int res = 0;
        for (Pair pair : intervals) {
            if (!queue.isEmpty() && queue.peek() < pair.left) {
                queue.poll();
                queue.add(pair.right);
            } else {
                res++;
                queue.add(pair.right);
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
            return this.left - pair.left;
        }
    }
}

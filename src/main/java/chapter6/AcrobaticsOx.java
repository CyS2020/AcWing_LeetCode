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
 * 描述：耍杂技的牛
 */
public class AcrobaticsOx {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line);
        List<Pair> oxs = new ArrayList<>();
        while ((line = input.readLine()) != null) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            oxs.add(new Pair(arr[0], arr[1]));
        }

        Collections.sort(oxs);

        int res = Integer.MIN_VALUE;
        int weights = 0;
        for (int i = 0; i < N; i++) {
            Pair ox = oxs.get(i);
            int weight = ox.weight;
            int strong = ox.strong;
            res = Math.max(res, weights - strong);
            weights += weight;
        }
        System.out.println(res);
    }


    public static class Pair implements Comparable<Pair> {
        int weight;
        int strong;

        public Pair(int weight, int strong) {
            this.weight = weight;
            this.strong = strong;
        }

        @Override
        public int compareTo(Pair pair) {
            int value1 = weight + strong;
            int value2 = pair.weight + pair.strong;
            return value1 - value2;
        }
    }
}

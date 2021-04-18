package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: CyS2020
 * @date: 2021/4/18
 * 描述：集合Nim游戏
 */
public class NimSet {

    public static Map<Integer, Integer> sgMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String line = input.readLine();
        int k = Integer.parseInt(line);
        line = input.readLine();
        int[] s = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        line = input.readLine();
        int n = Integer.parseInt(line);
        line = input.readLine();
        int[] h = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        int res = 0;
        for (int v : h) {
            res ^= SG(v, s);
        }
        System.out.println(res == 0 ? "No" : "Yes");
    }

    public static int SG(int n, int[] s) {
        if (sgMap.containsKey(n)) {
            return sgMap.get(n);
        }
        Set<Integer> state = new HashSet<>();
        for (int v : s) {
            if (n - v >= 0) {
                state.add(SG(n - v, s));
            }
        }
        for (int i = 0; ; i++) {
            if (state.isEmpty() || !state.contains(i)) {
                sgMap.put(n, i);
                return i;
            }
        }
    }
}

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
 * 描述：拆分Nim游戏
 */
public class NimSplit {

    public static Map<Integer, Integer> sgMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String line = input.readLine();
        int n = Integer.parseInt(line);
        line = input.readLine();
        int[] s = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        int res = 0;
        for (int v : s) {
            res ^= SG(v);
        }
        System.out.println(res == 0 ? "No" : "Yes");
    }

    public static int SG(int n) {
        if (sgMap.containsKey(n)) {
            return sgMap.get(n);
        }
        Set<Integer> state = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                state.add(SG(i) ^ SG(j));
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

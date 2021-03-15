package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: CyS2020
 * @date: 2021/3/12
 * 描述：最长连续不重复子序列
 * 口诀：循环数组双指针，左i右j需check
 */
public class LongestSubSeq {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        line = input.readLine();
        int[] q = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int len = maxLength(q);
        System.out.println(len);
    }

    public static int maxLength(int[] q) {
        int len = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0, j = 0; j < q.length; j++) {
            int a = q[j];
            while (set.contains(a)) {
                set.remove(q[i++]);
            }
            set.add(a);
            len = Math.max(len, set.size());
        }
        return len;
    }
}

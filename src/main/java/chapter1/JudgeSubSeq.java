package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/12
 * 描述：判断子序列
 * 口诀：循环数组双指针，小i小j需check
 */
public class JudgeSubSeq {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        line = input.readLine();
        int[] a = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        line = input.readLine();
        int[] b = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        String isSub = isSubseq(a, b);
        System.out.println(isSub);
    }

    public static String isSubseq(int[] a, int[] b) {
        if (a.length > b.length) {
            return "No";
        }
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                i++;
            }
            j++;
        }
        return i == a.length ? "Yes" : "No";
    }
}

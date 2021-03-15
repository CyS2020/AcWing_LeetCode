package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: CyS2020
 * @date: 2021/3/3
 * 描述：高精度加法
 * 口诀：人工计算，进位借位
 * 等同于：BigDecimal.add()方法
 */
public class OperationAdd {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        List<Integer> a = Arrays.stream(line.split("")).map(Integer::parseInt).collect(Collectors.toList());
        line = input.readLine();
        List<Integer> b = Arrays.stream(line.split("")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> c = add(a, b);
        c.forEach(System.out::print);
    }

    private static List<Integer> add(List<Integer> a, List<Integer> b) {
        LinkedList<Integer> c = new LinkedList<>();
        int t = 0;
        for (int i = a.size() - 1, j = b.size() - 1; i >= 0 || j >= 0 || t > 0; i--, j--) {
            if (i >= 0) {
                t += a.get(i);
            }
            if (j >= 0) {
                t += b.get(j);
            }
            c.addFirst(t % 10);
            t = t / 10 > 0 ? 1 : 0;
        }
        return c;
    }
}

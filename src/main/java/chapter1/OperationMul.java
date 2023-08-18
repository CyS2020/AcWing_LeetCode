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
 * @date: 2021/3/5
 * 描述：高精度乘法
 * 口诀：人工计算，进位借位
 */
class OperationMul {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        List<Integer> a = Arrays.stream(line.split("")).map(Integer::parseInt).collect(Collectors.toList());
        line = input.readLine();
        int b = Integer.parseInt(line);
        List<Integer> c = mul(a, b);
        c.forEach(System.out::print);
    }

    public static List<Integer> mul(List<Integer> a, int b) {
        LinkedList<Integer> c = new LinkedList<>();
        int i = a.size() - 1;
        int t = 0;
        while(i >= 0 || t > 0){
            if(i >= 0){
                t = t + b * a.get(i--);
            }
            c.addFirst(t % 10);
            t /= 10;
        }
        while(c.getFirst() == 0 && c.size() > 1){
            c.pop();
        }
        return c;
    }
}

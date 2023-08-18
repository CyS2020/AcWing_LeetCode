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
 * 描述：高精度除法https://github.com/CyS2020/AcWing_LeetCode/blob/main/src/main/java/chapter1/OperationDiv.java
 * 口诀：人工计算，进位借位
 */
class OperationDiv {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        List<Integer> a = Arrays.stream(line.split("")).map(Integer::parseInt).collect(Collectors.toList());
        line = input.readLine();
        int b = Integer.parseInt(line);
        Result c = div(a, b);
        System.out.println(c);
    }

    public static Result div(List<Integer> a, int b) {
        LinkedList<Integer> c = new LinkedList<>();
        int i = 0;
        int t = 0;
        while (i < a.size()) {
            t = t * 10 + a.get(i++);
            c.add(t / b);
            t %= b;
        }
        while (c.getFirst() == 0 && c.size() > 1) {
            c.pop();
        }
        return new Result(c, t);
    }

    public static class Result {
        private final List<Integer> c;
        private final int r;

        public Result(List<Integer> c, int r) {
            this.c = c;
            this.r = r;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            c.forEach(sb::append);
            sb.append("\n");
            sb.append(r);
            return sb.toString();
        }
    }
}

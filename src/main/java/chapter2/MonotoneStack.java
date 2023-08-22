package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: CyS2020
 * @date: 2021/3/21
 * 描述：单调栈
 * 口诀：栈头元素需清理，栈头插入仍单调
 */
class MonotoneStack {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> stack = new LinkedList<>();
        for (int i : arr) {
            while (!stack.isEmpty() && stack.peek() >= i) {
                stack.poll();
            }
            if (stack.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(stack.peek() + " ");
            }
            stack.push(i);
        }
    }
}

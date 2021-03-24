package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: CyS2020
 * @date: 2021/3/22
 * 描述：四则运算
 * 口诀：右括乘除优先级，从右往左来计算
 */
public class Arithmetic {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        char[] chars = line.toCharArray();

        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        Deque<Character> opera = new LinkedList<>();
        Deque<Integer> num = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                int x = 0;
                int j = i;
                while (j < chars.length && Character.isDigit(chars[j])) {
                    x = x * 10 + chars[j++] - '0';
                }
                i = j - 1;
                num.addLast(x);
            } else if (c == '(') {
                opera.addLast(c);
            } else if (c == ')') {
                while (opera.peekLast() != '(') {
                    evaluate(opera, num);
                }
                opera.pollLast();
            } else {
                while (!opera.isEmpty() && opera.peekLast() != '('
                        && priority.get(opera.peekLast()) >= priority.get(c)) {
                    evaluate(opera, num);
                }
                opera.addLast(c);
            }
        }
        while (!opera.isEmpty()) {
            evaluate(opera, num);
        }
        System.out.println(num.peekLast());
    }

    public static void evaluate(Deque<Character> opera, Deque<Integer> num) {
        int b = num.pollLast();
        int a = num.pollLast();
        char c = opera.pollLast();
        switch (c) {
            case '+':
                num.addLast(a + b);
                break;
            case '-':
                num.addLast(a - b);
                break;
            case '*':
                num.addLast(a * b);
                break;
            case '/':
                num.addLast(a / b);
                break;
        }
    }
}

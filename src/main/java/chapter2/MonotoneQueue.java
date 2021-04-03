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
 * 描述：单调队列
 * 口诀：队尾元素需清理，队尾插入仍单调
 */
public class MonotoneQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = arr[1];
        line = input.readLine();
        arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Pair> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!queue.isEmpty() && i - queue.peekFirst().index + 1 > k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && queue.peekLast().value >= arr[i]) {
                queue.pollLast();
            }
            queue.addLast(new Pair(i, arr[i]));
            if (i >= k - 1) {
                System.out.print(queue.peekFirst().value + " ");
            }
        }

        System.out.println();
        queue.clear();

        for (int i = 0; i < arr.length; i++) {
            if (!queue.isEmpty() && i - queue.peekFirst().index + 1 > k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && queue.peekLast().value <= arr[i]) {
                queue.pollLast();
            }
            queue.addLast(new Pair(i, arr[i]));
            if (i >= k - 1) {
                System.out.print(queue.peekFirst().value + " ");
            }
        }
    }

    public static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}

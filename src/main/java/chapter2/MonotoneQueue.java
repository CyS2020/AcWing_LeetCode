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
 * 描述：滑动窗口
 * 口诀：使用单调队列进行操作，队尾元素需清理，队尾插入仍单调
 */
public class MonotoneQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = arr[1];
        line = input.readLine();
        arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        minSlidingWindow(arr, k);
        System.out.println();
        maxSlidingWindow(arr, k);
    }

    private static void minSlidingWindow(int[] arr, int k) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (!queue.isEmpty() && arr[queue.peekLast()] > arr[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        for (int i = k - 1; i < arr.length; i++) {
            if (!queue.isEmpty() && i - queue.peekFirst() + 1 > k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && arr[queue.peekLast()] > arr[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            System.out.print(arr[queue.peekFirst()] + " ");
        }
    }

    private static void maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (!queue.isEmpty() && arr[queue.peekLast()] < arr[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        for (int i = k - 1; i < arr.length; i++) {
            if (!queue.isEmpty() && i - queue.peekFirst() + 1 > k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && arr[queue.peekLast()] < arr[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            System.out.print(arr[queue.peekFirst()] + " ");
        }
    }
}

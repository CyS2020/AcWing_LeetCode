package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/3/21
 * 描述：单调队列
 */
public class MonotoneQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = arr[1];
        line = input.readLine();
        arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> queue = new LinkedList<>();
        List<Integer> maxList = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            queue.add(arr[i]);
        }
        for (int i = k - 1; i < arr.length; i++) {
            queue.addLast(arr[i]);
            int min = Collections.min(queue);
            int max = Collections.max(queue);
            System.out.print(min + " ");
            maxList.add(max);
            queue.pollFirst();
        }
        System.out.println();
        for (int i : maxList) {
            System.out.print(i + " ");
        }
    }
}

package chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/4/29
 * 描述：霍夫曼树
 */
public class Huffman {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line.trim());
        line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        int res = huffman(arr);
        System.out.println(res);
    }

    public static int huffman(int[] arr) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int value : arr) {
            queue.add(value);
        }

        int res = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            queue.add(a + b);
            res += a + b;
        }
        return res;
    }
}

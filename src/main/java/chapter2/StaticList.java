package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/3/17
 * 描述：静态单链表
 * 口诀：数组索引分内存
 */
public class StaticList {

    public static int[] e = new int[100010];

    public static int[] ne = new int[100010];

    public static int head = -1, idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            String[] arr = line.split(" ");
            switch (arr[0]) {
                case "H":
                    addToHead(Integer.parseInt(arr[1]));
                    break;
                case "I":
                    addToKth(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                    break;
                case "D":
                    deleteKth(Integer.parseInt(arr[1]));
            }
        }
        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }

    }

    public static void deleteKth(int k) {
        if (k == 0) {
            head = ne[head];
        } else {
            ne[k] = ne[ne[k]];
        }
    }

    public static void addToKth(int k, int value) {
        e[idx] = value;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    public static void addToHead(int value) {
        e[idx] = value;
        ne[idx] = head;
        head = idx++;
    }
}

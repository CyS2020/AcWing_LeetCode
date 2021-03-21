package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/3/21
 * 描述：静态双链表
 */
public class StaticBiList {

    public static int[] e = new int[100010];

    public static int[] l = new int[100010];

    public static int[] r = new int[100010];

    public static int index = 2;

    static {
        r[0] = 1;
        l[1] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            String[] arr = line.split(" ");
            switch (arr[0]) {
                case "L":
                    addToHead(Integer.parseInt(arr[1]));
                    break;
                case "R":
                    addToTail(Integer.parseInt(arr[1]));
                    break;
                case "D":
                    deleteKth(Integer.parseInt(arr[1]));
                    break;
                case "IL":
                    addToKthLeft(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                    break;
                case "IR":
                    addToKthRight(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                    break;
            }
        }
        for (int i = r[0]; i != 1; i = r[i]) {
            System.out.print(e[i] + " ");
        }
    }

    public static void addToHead(int value) {
        e[index] = value;
        r[index] = r[0];
        l[index] = 0;
        l[r[0]] = index;
        r[0] = index;
        index++;
    }

    public static void addToTail(int value) {
        e[index] = value;
        r[index] = 1;
        l[index] = l[1];
        r[l[1]] = index;
        l[1] = index;
        index++;
    }

    public static void deleteKth(int k) {
        k = k + 1;//index初始化为2
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

    public static void addToKthLeft(int k, int value) {
        k = k + 1;//index初始化为2
        e[index] = value;
        r[index] = k;
        l[index] = l[k];
        r[l[k]] = index;
        l[k] = index;
        index++;
    }

    public static void addToKthRight(int k, int value) {
        k = k + 1;//index初始化为2
        e[index] = value;
        r[index] = r[k];
        l[index] = k;
        l[r[k]] = index;
        r[k] = index;
        index++;
    }
}

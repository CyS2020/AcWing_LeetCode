package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/4/3
 * 描述：哈希表
 * 口诀：线性探测法
 */
public class HashDetect {

    private int n;

    private Integer[] table;

    public HashDetect(int n) {
        this.n = n * 2;
        this.table = new Integer[n * 2];
    }

    public void insert(int x) {
        int k = find(x);
        table[k] = x;
    }

    public boolean query(int x) {
        int k = find(x);
        if (table[k] == null) {
            return false;
        }
        return true;
    }

    private int find(int x) {
        int k = (x % n + n) % n;
        while (table[k] != null && table[k] != x) {
            k = (k + 1) % n;
        }
        return k;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        HashZipper hash = new HashZipper(n);
        while ((line = input.readLine()) != null) {
            String[] arr = line.split(" ");
            String op = arr[0];
            int x = Integer.parseInt(arr[1]);
            switch (op) {
                case "I":
                    hash.insert(x);
                    break;
                case "Q":
                    boolean b = hash.query(x);
                    System.out.println(b ? "Yes" : "No");
                    break;
            }
        }
    }
}

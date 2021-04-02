package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/3/31
 * 描述：索引优先队列
 * 口诀：某位锁存数据值，某值所在索引位，元素数组不可变
 */
public class IndexQueue {
    // 元素数组
    private final int[] items;
    // 堆
    private final int[] ph;
    // 堆位置
    private final int[] hp;

    private int itemIdx = 0;

    private int headIdx = 0;

    public IndexQueue(int n) {
        this.items = new int[n + 1];
        this.ph = new int[n + 1];
        this.hp = new int[n + 1];
    }

    public int poll() {
        int item = items[ph[1]];
        swap(1, headIdx--);
        down(1);
        return item;
    }

    public int peek() {
        return items[ph[1]];
    }

    public void Insert(int item) {
        items[++itemIdx] = item;
        ph[++headIdx] = itemIdx;
        hp[itemIdx] = headIdx;
        up(headIdx);
    }

    // 更一般情况为删除某个元素
    public void delete(int kth) {
        int u = hp[kth];
        swap(u, headIdx--);
        down(u);
        up(u);
    }

    public void update(int kth, int newItem) {
        items[kth] = newItem;
        int u = hp[kth];
        down(u);
        up(u);
    }

    private void swap(int i, int j) {
        // 堆变化
        int tmp = ph[i];
        ph[i] = ph[j];
        ph[j] = tmp;
        // 堆中位置变化
        hp[ph[i]] = i;
        hp[ph[j]] = j;
    }

    private void up(int u) {
        while (u / 2 > 0 && compareTo(u / 2, u) > 0) {
            swap(u / 2, u);
            u = u / 2;
        }
    }

    private void down(int u) {
        int t = u;
        if (2 * u <= headIdx && compareTo(t, 2 * u) > 0) {
            t = 2 * u;
        }
        if (2 * u + 1 <= headIdx && compareTo(t, 2 * u + 1) > 0) {
            t = 2 * u + 1;
        }
        if (t != u) {
            swap(t, u);
            down(t);
        }
    }

    public int compareTo(int headIdx1, int headIdx2) {
        return items[ph[headIdx1]] - items[ph[headIdx2]];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        IndexQueue indexQueue = new IndexQueue(n);
        while ((line = input.readLine()) != null) {
            String[] strs = line.split(" ");
            switch (strs[0]) {
                case "I":
                    indexQueue.Insert(Integer.parseInt(strs[1]));
                    break;
                case "PM":
                    System.out.println(indexQueue.peek());
                    break;
                case "DM":
                    indexQueue.poll();
                    break;
                case "D":
                    indexQueue.delete(Integer.parseInt(strs[1]));
                    break;
                case "C":
                    indexQueue.update(Integer.parseInt(strs[1]), Integer.parseInt(strs[2]));
                    break;
            }
        }
    }
}

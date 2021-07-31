package codeoffer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/5/30
 * 描述：数据流中的中位数
 * 思路：小根堆维护较大到的一半数，大根堆维护较小的一半数，且堆大小相差不超过2
 */
public class Median {

    Queue<Integer> minHeap = new PriorityQueue<>();

    Queue<Integer> maxHeap = new PriorityQueue<>(this::compareTo);

    public void addNum(int num) {
        maxHeap.add(num);
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int maxv = maxHeap.poll();
            int minv = minHeap.poll();
            maxHeap.add(minv);
            minHeap.add(maxv);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            int maxv = maxHeap.peek();
            int minv = minHeap.peek();
            return (maxv + minv) / 2.0;
        }
        return maxHeap.peek();
    }

    public int compareTo(int a, int b) {
        return b - a;
    }
}

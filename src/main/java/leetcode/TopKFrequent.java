package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/10/24
 * 描述：前k个高频元素
 * 思路：使用堆进行处理
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int num : nums) {
            Pair pair = map.getOrDefault(num, new Pair(num, 0));
            map.put(num, pair.increment());
        }
        Queue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            pq.add(entry.getValue());
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().num;
        }
        return res;
    }

    public static class Pair implements Comparable<Pair> {

        public Integer num;

        public Integer count;

        public Pair(Integer num, Integer count) {
            this.num = num;
            this.count = count;
        }

        public Pair increment() {
            this.count++;
            return this;
        }

        @Override
        public int compareTo(Pair o) {
            return o.count - this.count;
        }
    }
}

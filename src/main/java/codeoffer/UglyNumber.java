package codeoffer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/6/21
 * 描述：丑数
 * 思路：三路归并
 */
public class UglyNumber {

    public int nthUglyNumber(int n) {
        List<Integer> queue = new LinkedList<>();
        queue.add(1);
        int i = 0, j = 0, k = 0;
        while (--n > 0) {
            int min = Math.min(queue.get(i) * 2, Math.min(queue.get(j) * 3, queue.get(k) * 5));
            queue.add(min);
            if (min == queue.get(i) * 2) {
                i++;
            }
            if (min == queue.get(j) * 3) {
                j++;
            }
            if (min == queue.get(k) * 5) {
                k++;
            }
        }
        return queue.get(queue.size() - 1);
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/10/24
 * 描述：根据身高重建队列
 * 思路：贪心策略与插空法
 */
public class HeightQueue {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, this::compareTo);
        List<int[]> res = new ArrayList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[0][]);
    }

    public int compareTo(int[] p1, int[] p2) {
        if (p1[0] != p2[0]) {
            return p2[0] - p1[0];
        }
        return p1[1] - p2[1];
    }
}

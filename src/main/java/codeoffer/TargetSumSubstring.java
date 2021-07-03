package codeoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/7/3
 * 描述：和为s的连续正数序列
 * 思路：双指针，i增大的时候j也增大，因为i增大导致sum减小，j增大导致sum增大
 */
public class TargetSumSubstring {

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int j = 1;
        int sum = 1;
        for (int i = 1; i <= target; i++) {
            while (sum < target) {
                j++;
                sum += j;
            }
            if (sum == target && j - i > 0) {
                int[] ans = new int[j - i + 1];
                for (int k = 0, v = i; v <= j; k++, v++) {
                    ans[k] = v;
                }
                res.add(ans);
            }
            sum -= i;
        }
        return res.toArray(new int[0][]);
    }
}

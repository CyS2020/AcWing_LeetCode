package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: CyS2020
 * @date: 2021/7/31
 * 描述：两数之和
 * 思路：将前面的数值保存下来，便于后面map查询
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int add = target - nums[i];
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(add), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

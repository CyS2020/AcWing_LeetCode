package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/9/5
 * 描述：子集
 * 思路：dfs，对不同长度进行dfs
 */
public class CombineSubArray {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int len = 0; len <= nums.length; len++) {
            dfs(nums, len, 0, new ArrayList<>());
        }
        return res;
    }

    public void dfs(int[] nums, int len, int idx, List<Integer> ans) {
        if (idx == len) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(nums, len, i + 1, ans);
            ans.remove(ans.size() - 1);
        }
    }
}

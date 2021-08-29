package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/8/29
 * 描述：全排雷
 * 思路：dfs
 */
public class CombineArray {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] st = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), st);
        return res;
    }

    public void dfs(int[] nums, List<Integer> ans, boolean[] st) {
        if (ans.size() == nums.length) {
            res.add(new ArrayList<>(ans));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!st[i]) {
                ans.add(nums[i]);
                st[i] = true;
                dfs(nums, ans, st);
                ans.remove(ans.size() - 1);
                st[i] = false;
            }

        }
    }
}

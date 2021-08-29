package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/8/22
 * 描述：组合总和
 * 思路：dfs; 28行if进行剪枝优化
 */
public class CombineSum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target, new ArrayList<>());
        return res;
    }

    public void dfs(int[] candidates, int index, int target, List<Integer> ans) {
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int newTgt = target - candidates[i];
            if (newTgt >= 0) {
                ans.add(candidates[i]);
                dfs(candidates, i, newTgt, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
}

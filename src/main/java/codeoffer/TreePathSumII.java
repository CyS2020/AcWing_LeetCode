package codeoffer;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/5/23
 * 描述：二叉树中和为某一值的路径
 */
public class TreePathSumII {

    List<List<Integer>> res = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.remove(path.size() - 1);
    }

    // 仅判断是否有路径无需返回路径
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (targetSum == root.val && root.left == null && root.right == null) {
            return true;
        }
        int left = targetSum - root.val;
        return hasPathSum(root.left, left) || hasPathSum(root.right, left);
    }
}

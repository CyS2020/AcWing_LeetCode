package codeoffer;

import base.TreeNode;

/**
 * @author: CyS2020
 * @date: 2021/10/26
 * 描述：路径总和 III
 * 思路：两次dfs
 */
public class TreePathSumIII {

    private int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path(root, targetSum, 0);
    }

    private void path(TreeNode root, int targetSum, int val) {
        if (root == null) {
            return;
        }
        int sum = root.val + val;
        if (sum == targetSum) {
            res++;
        }
        path(root.left, targetSum, sum);
        path(root.right, targetSum, sum);
    }
}

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
        if (root == null) {
            return res;
        }
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }


    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        if (targetSum == 0) {
            res++;
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }
}

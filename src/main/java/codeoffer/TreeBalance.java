package codeoffer;

import base.TreeNode;

/**
 * @author: CyS2020
 * @date: 2021/7/15
 * 描述：判断平衡二叉树
 * 思路：递归求树的高度
 */
public class TreeBalance {

    public boolean res = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        return Math.max(left, right) + 1;
    }
}

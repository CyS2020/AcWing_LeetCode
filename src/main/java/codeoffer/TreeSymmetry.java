package codeoffer;

import base.TreeNode;

/**
 * @author: CyS2020
 * @date: 2021/5/16
 * 描述：对称的二叉树
 * 思路：子数左边与右边比较
 */
public class TreeSymmetry {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode l, TreeNode r) {
        if (l == null || r == null) {
            return l == null && r == null;
        }
        if (l.val == r.val) {
            return dfs(l.left, r.right) && dfs(l.right, r.left);
        }
        return false;
    }
}

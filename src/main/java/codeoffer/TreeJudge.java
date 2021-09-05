package codeoffer;

import base.TreeNode;

/**
 * @author: CyS2020
 * @date: 2021/9/5
 * 描述： 验证二叉搜索树
 * 思路：dfs
 */
public class TreeJudge {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long l, long r) {
        if (root == null) {
            return true;
        }
        if (root.val <= l || root.val >= r) {
            return false;
        }
        return dfs(root.left, l, root.val) && dfs(root.right, root.val, r);
    }
}

package codeoffer;

import base.TreeNode;

/**
 * @author: CyS2020
 * @date: 2021/9/12
 * 描述：二叉树展开为链表
 * 思路：左子树的最下最右的节点，是右子树的父节点.
 */
public class TreeToList {

    public void flatten(TreeNode root) {
        dfs(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        dfs(leftNode);
        root.right = root.left;
        root.left = null;
        // 左子树的最下最右的节点
        while (root.right != null) {
            root = root.right;
        }
        dfs(rightNode);
        // 是右子树的父节点
        root.right = rightNode;
    }
}

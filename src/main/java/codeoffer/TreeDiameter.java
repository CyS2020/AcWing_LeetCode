package codeoffer;

import base.TreeNode;

/**
 * @author: CyS2020
 * @date: 2021/10/25
 * 描述：二叉树的直径
 */
public class TreeDiameter {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max - 1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        max = Math.max(max, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

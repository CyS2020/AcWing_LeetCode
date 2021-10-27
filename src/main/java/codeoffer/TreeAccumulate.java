package codeoffer;

import base.TreeNode;

/**
 * @author: CyS2020
 * @date: 2021/10/27
 * 描述：把二叉搜索树转换为累加树
 */
public class TreeAccumulate {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}

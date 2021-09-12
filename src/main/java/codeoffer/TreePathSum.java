package codeoffer;

import base.TreeNode;

/**
 * @author: CyS2020
 * @date: 2021/9/12
 * 描述：二叉树中的最大路径和
 * 思路：val + 左边最大值 + 右边最大值 = maxSum; 同时记得左右两边最大值不能是负数
 * dfs返回的是某一侧的最大值
 */
public class TreePathSum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        maxSum = Math.max(maxSum, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}

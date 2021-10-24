package leetcode;

import base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: CyS2020
 * @date: 2021/10/24
 * 描述：打家劫舍
 * 思路：树形DP
 */
public class HouseRobberyIII {

    private final Map<TreeNode, Integer> rob = new HashMap<>();

    private final Map<TreeNode, Integer> unrob = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(rob.getOrDefault(root, 0), unrob.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        dfs(left);
        dfs(right);
        rob.put(root, root.val + unrob.getOrDefault(left, 0) + unrob.getOrDefault(right, 0));
        int leftMax = Math.max(rob.getOrDefault(left, 0), unrob.getOrDefault(left, 0));
        int rightMax = Math.max(rob.getOrDefault(right, 0), unrob.getOrDefault(right, 0));
        unrob.put(root, leftMax + rightMax);
    }
}

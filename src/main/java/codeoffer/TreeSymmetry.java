package codeoffer;

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

    public boolean dfs(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return A == null && B == null;
        }
        if (A.val == B.val) {
            return dfs(A.left, B.right) && dfs(A.right, B.left);
        }
        return false;
    }
}

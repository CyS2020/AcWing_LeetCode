package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/7/16
 * 描述：二叉树的最近公共祖先
 * 思路：普通二叉树无序的
 */
public class TreeAncestorll {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == q || root == p) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}

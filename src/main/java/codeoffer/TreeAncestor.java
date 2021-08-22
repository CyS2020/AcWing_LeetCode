package codeoffer;

import base.TreeNode;

/**
 * @author: CyS2020
 * @date: 2021/7/16
 * 描述：二叉搜索树的最近公共祖先
 * 思路：二叉搜索树是有左小右大的顺序的
 */
public class TreeAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}

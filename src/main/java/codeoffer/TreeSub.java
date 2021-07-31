package codeoffer;

import base.TreeNode;

/**
 * @author: CyS2020
 * @date: 2021/5/16
 * 描述：数的子结构
 * 思路：两次dfs
 */
public class TreeSub {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (isSame(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSame(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}

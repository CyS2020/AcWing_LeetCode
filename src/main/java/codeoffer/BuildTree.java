package codeoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: CyS2020
 * @date: 2021/5/6
 * 描述：重建二叉树
 * 口诀：前序遍历--根左右，中序遍历--左根右，后序遍历--左右根
 * 思路：距离等于 i - il + 1，位置等于 pl + i - il + 1 -1
 */
public class BuildTree {

    Map<Integer, Integer> index = new HashMap<>();

    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        return dfs(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode dfs(int pl, int pr, int il, int ir) {
        if (il > ir) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int i = index.get(preorder[pl]);
        TreeNode left = dfs(pl + 1, pl + i - il, il, i - 1);
        TreeNode right = dfs(pl + i - il + 1, pr, i + 1, ir);
        root.left = left;
        root.right = right;
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

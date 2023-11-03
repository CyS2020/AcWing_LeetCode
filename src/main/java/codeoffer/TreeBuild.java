package codeoffer;

import base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: CyS2020
 * @date: 2021/5/6
 * 描述：重建二叉树
 * 口诀：前序遍历--根左右，中序遍历--左根右，后序遍历--左右根
 * 思路：距离等于 i - il + 1，位置等于 pl + i - il + 1 -1
 */
public class TreeBuild {

    private final Map<Integer, Integer> index = new HashMap<>();

    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        return dfs(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode dfs(int preLeft, int preRight, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode node = new TreeNode(rootVal);

        int loc = index.get(preorder[preLeft]);
        int len = loc - inLeft;
        TreeNode leftNode = dfs(preLeft + 1, preLeft + len, inLeft, loc - 1);
        TreeNode rightNode = dfs(preLeft + len + 1, preRight, loc + 1, inRight);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}

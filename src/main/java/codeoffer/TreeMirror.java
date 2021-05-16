package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/16
 * 描述：二叉树的镜像
 */
public class TreeMirror {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = mirrorTree(left);
        root.left = mirrorTree(right);
        return root;
    }
}

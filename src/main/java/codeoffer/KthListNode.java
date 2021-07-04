package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/7/4
 * 描述：二叉搜索树的第k大节点
 * 思路：从大到小的中序遍历，如果是第k小的数则就是正常中序遍历
 */
public class KthListNode {

    public int k, res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (--k == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }
}

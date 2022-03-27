package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/19
 * 描述：后序遍历
 * 思路：根据二叉搜索树的规则左小又大，进行检查检查通过则为true
 */
public class IsPostOrder {

    private int[] postorder;

    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        int len = postorder.length;
        return dfs(0, len - 1);
    }

    public boolean dfs(int l, int r) {
        if (l >= r) {
            return true;
        }
        int k = l - 1;
        while (postorder[++k] < postorder[r]) ;
        for (int i = k; i < r; i++) {
            if (postorder[i] < postorder[r]) {
                return false;
            }
        }
        return dfs(l, k - 1) && dfs(k, r - 1);
    }
}

package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/19
 * 描述：后序遍历
 * 思路：根据二叉搜索树的规则左小又大，进行检查检查通过则为true
 */
public class IsPostOrder {

    private int[] postOrder;

    public boolean verifyPostOrder(int[] postOrder) {
        this.postOrder = postOrder;
        int len = postOrder.length;
        return dfs(0, len - 1);
    }

    public boolean dfs(int l, int r) {
        if (l >= r) {
            return true;
        }
        int root = postOrder[r];
        int k = -1;
        while (postOrder[++k] < postOrder[r]) ;
        for (int i = k; i < r; i++) {
            if (postOrder[i] < postOrder[r]) {
                return false;
            }
        }
        return dfs(l, k - 1) && dfs(k, r - 1);
    }
}

package codeoffer;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/5/23
 * 描述：二叉树和为某一直的路径
 */
public class TreeTarget {

    List<List<Integer>> res = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.remove(path.size() - 1);
    }
}

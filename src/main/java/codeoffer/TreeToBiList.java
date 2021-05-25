package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/25
 * 描述：二叉搜索树转为双向链表
 * 思路：递归每次返回最左与最右
 */
public class TreeToBiList {

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Pair res = dfs(root);
        res.left.left = res.right;
        res.right.right = res.left;
        return res.left;
    }

    public Pair dfs(Node root) {
        if (root.left == null && root.right == null) {
            return new Pair(root, root);
        } else if (root.left != null && root.right != null) {
            Pair l = dfs(root.left);
            Pair r = dfs(root.right);
            l.right.right = root;
            r.left.left = root;
            root.left = l.right;
            root.right = r.left;
            return new Pair(l.left, r.right);
        } else if (root.left != null) {
            Pair l = dfs(root.left);
            l.right.right = root;
            root.left = l.right;
            return new Pair(l.left, root);
        } else {
            Pair r = dfs(root.right);
            r.left.left = root;
            root.right = r.left;
            return new Pair(root, r.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        root.left = left;
        root.right = right;

        TreeToBiList to = new TreeToBiList();
        to.treeToDoublyList(root);
    }

    public class Pair {
        Node left;
        Node right;

        public Pair(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}

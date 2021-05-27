package codeoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/5/26
 * 描述：二叉树序列化与反序列化
 * 思路：按照前序遍历序列化，按照前序遍历反序列化
 */
public class TreeSerialize {

    private List<String> seList = new ArrayList<>();

    private List<String> deList;

    private int index = 0;

    public String serialize(TreeNode root) {
        dfsSe(root);
        return seList.toString();
    }

    private void dfsSe(TreeNode root) {
        if (root == null) {
            seList.add("null");
            return;
        }
        seList.add(String.valueOf(root.val));
        dfsSe(root.left);
        dfsSe(root.right);
    }

    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        deList = Arrays.asList(data.split(", "));
        return dfsDe();
    }

    private TreeNode dfsDe() {
        if (index == deList.size()) {
            return null;
        }
        String val = deList.get(index);
        index++;
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = dfsDe();
        node.right = dfsDe();
        return node;
    }
}

package nowcoder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化二叉树
 * @author Huangting
 * @date 2020/1/9
 * @time 17:40
 */
public class _61_Srialize {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode7.right = treeNode8;
        _61_Srialize print = new _61_Srialize();
        String a = print.Serialize(treeNode1);
        TreeNode treeNode = print.Deserialize(a);
        System.out.println(treeNode.val);
    }

    private String Serialize(TreeNode root) {
        return rSerialize(root, "");
    }

    private String rSerialize(TreeNode root, String str) {
        // Recursive serialization.
        if (root == null) {
            str += "#,";
        } else {
            str += root.val + ",";
            str = rSerialize(root.left, str);
            str = rSerialize(root.right, str);
        }
        return str;
    }

    private TreeNode Deserialize(String str) {
        String[] strings = str.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strings));
        return rDeserialize(list);
    }

    private TreeNode rDeserialize(List<String> l) {
        if (l.get(0).equals("#")) {
            l.remove(0);
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(String.valueOf(l.remove(0))));
        treeNode.left = rDeserialize(l);
        treeNode.right = rDeserialize(l);
        return treeNode;
    }
}

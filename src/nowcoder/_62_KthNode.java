package nowcoder;

/**
 * 二叉搜索树的第k个节点
 * @author Huangting
 * @date 2020/1/10
 * @time 10:39
 */
public class _62_KthNode {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode5;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode7;
        _62_KthNode kthNode = new _62_KthNode();
        TreeNode treeNode = kthNode.KthNode(treeNode1, 3);
        System.out.println(treeNode.val);
    }

    private int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        TreeNode leftNode = KthNode(pRoot.left, k);
        if (leftNode != null) {
            return leftNode;
        }
        index++;
        if (index == k) {
            return pRoot;
        }
        TreeNode rightNode = KthNode(pRoot.right, k);
        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }
}

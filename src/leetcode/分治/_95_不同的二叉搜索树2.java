package leetcode.分治;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/25
 */
public class _95_不同的二叉搜索树2 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        _95_不同的二叉搜索树2 _95 = new _95_不同的二叉搜索树2();
        _95.generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        return generateSubtrees(1, n);

    }

    private List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; i++) {
            List<TreeNode> leftSubTrees = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubTrees = generateSubtrees(i + 1, e);
            for (TreeNode left : leftSubTrees) {
                for (TreeNode right : rightSubTrees) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    res.add(treeNode);
                }
            }
        }
        return res;
    }
}

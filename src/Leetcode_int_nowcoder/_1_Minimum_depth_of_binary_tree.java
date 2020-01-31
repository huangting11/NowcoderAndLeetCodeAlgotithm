package Leetcode_int_nowcoder;

import sun.reflect.generics.tree.Tree;

/**
 * 求给定二叉树的最小深度
 * @Author Huangting
 * @Time 2020/1/15
 */
public class _1_Minimum_depth_of_binary_tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        _1_Minimum_depth_of_binary_tree minimum_depth_of_binary_tree = new _1_Minimum_depth_of_binary_tree();
        System.out.println(minimum_depth_of_binary_tree.run(treeNode1));
    }

    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null || root.right == null){
            return Math.max(run(root.left),run(root.right)) + 1;
        }
        return  Math.min(run(root.left),run(root.right)) + 1;
    }
}

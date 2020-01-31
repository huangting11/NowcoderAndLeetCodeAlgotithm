package leetcode.搜索.Backtracking;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/29
 */
public class _257_二叉树的所有路径 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> nodeRoads = new ArrayList<>();
        backtracking(nodeRoads, new ArrayList<>(), root);
        return nodeRoads;
    }

    private void backtracking(List<String> nodeRoads, List<Integer> values, TreeNode node) {
        if (node == null) {
            return;
        }
        values.add(node.val);
        if (node.left == null && node.right == null) {
            nodeRoads.add(buildPath(values));
        }else {
            backtracking(nodeRoads, values, node.left);
            backtracking(nodeRoads, values, node.right);
        }
        values.remove(values.size() - 1);
    }

    private String buildPath(List<Integer> values) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            stringBuilder.append(values.get(i));
            if (i != values.size() - 1) {
                stringBuilder.append("->");
            }
        }
        return stringBuilder.toString();
    }
}

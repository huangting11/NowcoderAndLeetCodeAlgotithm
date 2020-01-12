import java.util.ArrayList;
import java.util.Stack;

/**
 * nowCoder按之字形顺序打印二叉树
 * @author Huangting
 * @date 2020/1/9
 * @time 15:56
 */
public class _59_Print {
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
        _59_Print print = new _59_Print();
        print.Print(treeNode1);
    }

    // List

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > arrayLists = new ArrayList<>();
        if (pRoot == null) {
            return arrayLists;
        }
        boolean flag = false;  //flag为false表示从左到右
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        stack1.push(pRoot);
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        while (stack1.size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            while (stack1.size() != 0) {
                TreeNode treeNode = stack1.pop();
                arrayList.add(treeNode.val);
                if (!flag) {
                    if (treeNode.left != null) {
                        stack2.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        stack2.add(treeNode.right);
                    }
                }else {
                    if (treeNode.right != null) {
                        stack2.add(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        stack2.add(treeNode.left);
                    }
                }
            }
            arrayLists.add(arrayList);
            flag = !flag;
            stack1 = stack2;
            stack2 = new Stack<>();
        }
        return arrayLists;
    }
}

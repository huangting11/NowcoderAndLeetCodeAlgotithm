public class Solution1 {

    private static int a;
    static {
        a = 100;
        System.out.println("2222311" + a);
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            //下一个节点在右子树的第一个节点
            TreeLinkNode a = pNode.right;
            while (a.left != null) {
                a = a.left;
            }
            return a;
        }

        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}

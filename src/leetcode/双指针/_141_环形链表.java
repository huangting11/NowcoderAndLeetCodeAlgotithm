package leetcode.双指针;

/**
 * @Author Huangting
 * @Time 2020/1/18
 */
public class _141_环形链表 {

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode highNode = head;
        ListNode lowNode = head;
        while (highNode.next != null && highNode.next.next != null) {
            highNode = highNode.next.next;
            lowNode = lowNode.next;
            if (lowNode == highNode) {
                return true;
            }
        }
        return false;
    }
}

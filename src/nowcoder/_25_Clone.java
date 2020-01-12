/**
 * 复杂链表的复制
 * @author Huangting
 * @date 2020/1/11
 * @time 10:35
 */
public class _25_Clone {

    public static void main(String[] args) {
        _25_Clone clone = new _25_Clone();
        RandomListNode a = clone.new RandomListNode(1);
        System.out.println(11);


        RandomListNode a1 = clone.new RandomListNode(1);
        RandomListNode a2 = clone.new RandomListNode(2);
        RandomListNode a3 = clone.new RandomListNode(3);
        RandomListNode a4 = clone.new RandomListNode(4);
        RandomListNode a5 = clone.new RandomListNode(5);
        a1.next = a2; a2.next = a3; a3.next = a4; a4.next = a5;
        a1.random = a3;  a2.random = a5; a4.random = a2;
        clone.Clone(a1);
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode current = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (current != null) {
            // RandomListNode cloneNode = new RandomListNode(current.label);
            // RandomListNode nextNode = current.next;
            // cloneNode.next = nextNode;
            // current.next = cloneNode;
            // current = nextNode;

            RandomListNode randomListNode = new RandomListNode(current.label);
            randomListNode.next = current.next;
            current.next = randomListNode;
            current = randomListNode.next;
        }

        current = pHead;
        //重新遍历链表，复制老节点随机指针给新节点
        while (current != null) {
            current.next.random = current.random == null ? null : current.random.next;
            current = current.next.next;
        }

/*        RandomListNode pCloneHead = pHead.next;
        current = pCloneHead;

        while (current != null) {
            RandomListNode cloneNode = current.next == null ? null : current.next.next;
            current.next = cloneNode;
            current = cloneNode;
        }*/

        //拆分链表，将链表拆分位原链表和复制后
        current = pHead;
        RandomListNode pCloneHead = current.next;
        while (current != null) {
            RandomListNode cloneNode = current.next;
            current.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            current = current.next;
        }
        return pCloneHead;
    }
}

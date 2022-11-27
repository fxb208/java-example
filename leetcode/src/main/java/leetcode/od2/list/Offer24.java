package leetcode.od2.list;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Offer24 {
    public static void main(String[] args) {
        Offer24 yb = new Offer24();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        yb.reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        while(node !=null){
            ListNode next = node.next;
            node.next=pre;
            pre = node;
            node=next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

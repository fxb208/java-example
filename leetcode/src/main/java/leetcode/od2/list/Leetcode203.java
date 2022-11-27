package leetcode.od2.list;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class Leetcode203 {
    public static void main(String[] args) {
        // [1,2,6,3,4,5,6]
        Leetcode203 yb = new Leetcode203();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        yb.removeElements(head,6);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode();
        ListNode node = head;
        ListNode temp = res;
        while(node !=null){
            if(node.val!=val){
                temp.next=node;
                temp=temp.next;
            }
            node=node.next;
        }
        temp.next = null;
        return res.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

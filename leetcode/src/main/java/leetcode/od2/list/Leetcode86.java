package leetcode.od2.list;

/**
 * 86. 分隔链表
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *  你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class Leetcode86 {
    public static void main(String[] args) {
        //
        Leetcode86 yb =new Leetcode86();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        yb.partition(head,3);

    }

    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode();
        ListNode left = res;
        ListNode res2 = new ListNode();
        ListNode right = res2;
        ListNode node = head;
        while(node !=null){
            if(node.val<x){
                left.next = node;
                left=left.next;
            }else{
                right.next=node;
                right=right.next;
            }
            node=node.next;
        }
        right.next=null;
        left.next=res2.next;
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

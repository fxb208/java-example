package leetcode.od2.list;

/**
 * 237. 删除链表中的节点
 * 有一个单链表的 head，我们想删除它其中的一个节点 node。
 * 给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
 * 链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
 * 删除给定的节点。
 */
public class Leetcode237 {
    public void deleteNode(ListNode node) {
        ListNode right = node.next;
        node.val=right.val;
        node.next=right.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }
}

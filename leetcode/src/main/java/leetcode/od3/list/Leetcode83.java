package leetcode.od3.list;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class Leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(node !=null){
            ListNode next = node.next;
            if(next !=null && next.val==node.val){
                next=next.next;
                node.next=next;
            }
            node = node.next;
        }
        return head;
    }

     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}

package leetcode.od3.list;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class Leetcode82 {
    public static void main(String[] args) {
        // 1,1,1,2,3
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        Leetcode82 yb = new Leetcode82();
        yb.deleteDuplicates(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode();
        ListNode pre = res;
        pre.next=head;
        ListNode node = head;
        while(node !=null){
            boolean del = false;
            ListNode right = node.next;
            while(right !=null && right.val== node.val){
                right = right.next;
                del = true;
            }
            if(del){
                pre.next=right;
            }else{
                pre.next=node;
                pre=node;
            }
            node=right;
        }
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

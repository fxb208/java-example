package leetcode.od.sort;

/**
 * 147. 对链表进行插入排序
 *  给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头
 */
public class Leetcode147 {
    public static void main(String[] args) {
        // 4 2 1 3
        ListNode head = new ListNode(4);
        head.next=new ListNode(2);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(3);
        Leetcode147 yb = new Leetcode147();
        yb.sortList(head);

    }

    public ListNode sortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode res = new ListNode(head.val);
        ListNode node = head.next;
        while(node !=null){
            ListNode temp = node.next;
            if(node.val<res.val){
                node.next=res;
                res = node;
            }else{
                ListNode nextNode = res.next;
                ListNode current = res;
                while(nextNode!=null && node.val>nextNode.val){
                    current = nextNode;
                    nextNode=nextNode.next;
                }
                current.next=node;
                node.next=nextNode;
            }
            node=temp;
        }
        return res;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}

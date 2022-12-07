package leetcode.od3.list;

/**
 * 92. 反转链表 II   206. 反转链表
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class Leetcode92 {
    public static void main(String[] args) {
        Leetcode92 yb = new Leetcode92();
        // 1,2,3,4,5
//        ListNode head = new ListNode(1);
//        head.next=new ListNode(2);
//        head.next.next=new ListNode(3);
//        head.next.next.next=new ListNode(4);
//        head.next.next.next.next=new ListNode(5);
//        yb.reverseBetween(head,2,4);

        ListNode head = new ListNode(5);
        yb.reverseBetween(head,1,1);

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        ListNode res = new ListNode();
        res.next=head;
        ListNode node = res;
        int idx = 0;
        while(node.next !=null){
            idx++;
            if(idx==left){
                ListNode pre = node;
                ListNode temp = node.next;
                ListNode leftNode = node.next;
                node = leftNode.next;
                idx++;
                while(idx < right){
                    ListNode temp2 = node.next;
                    node.next=temp;
                    temp = node;
                    node = temp2;
                    idx++;
                }
                ListNode temp2 = node.next;
                pre.next = node;
                node.next=temp;
                leftNode.next=temp2;
                break;
            }
            node = node.next;
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

package leetcode.od.sort;


/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class Leetcode148 {
    public static void main(String[] args) {
        // 4 2 1 3
        ListNode head = new ListNode(4);
        head.next=new ListNode(2);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(3);
        Leetcode148 yb = new Leetcode148();
        ListNode res = yb.sortList(head);
        System.out.println(res);
    }

    public ListNode sortList(ListNode head) {
        return sort(head,null);
    }

    public ListNode sort(ListNode head,ListNode tail) {
        if(head==null){
            return null;
        }
        if(head==tail){
            return head;
        }
        ListNode middle = middleNode(head,tail);
        ListNode temp = middle.next;
        middle.next=null;
        ListNode node1=sort(head,middle);
        ListNode node2=sort(temp,tail);
        return merge(node1,node2);
    }

    public ListNode middleNode(ListNode head,ListNode tail) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=tail){
            fast=fast.next;
            if(fast.next!=tail){
                fast=fast.next;
                slow=slow.next;
            }
        }
        return slow;
    }

    public ListNode merge(ListNode node1,ListNode node2){
        ListNode res = new ListNode();
        ListNode temp = res;
        while(node1 !=null || node2 !=null){
            if(node1 !=null && node2 !=null) {
                if (node1.val < node2.val) {
                    temp.next = node1;
                    node1 = node1.next;
                } else {
                    temp.next = node2;
                    node2 = node2.next;
                }
                temp=temp.next;
            }else if(node1==null){
                temp.next=node2;
                break;
            }else{
                temp.next=node1;
                break;
            }
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

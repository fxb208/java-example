package leetcode.od.list;

import java.util.List;

/**
 *
 */
public class Leetcode160 {
    public static void main(String[] args) {
        // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
        Leetcode160 leetcode = new Leetcode160();

        ListNode intersect = new ListNode(1);
        intersect.next=new ListNode(8);
        intersect.next.next=new ListNode(4);
        intersect.next.next.next=new ListNode(5);
        // listA
        ListNode headA = new ListNode(4);
        headA.next = intersect ;
        // listB
        ListNode headB = new ListNode(5);
        headB.next=new ListNode(6);
        headB.next.next=intersect;
        leetcode.getIntersectionNode(headA,headB);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while(node1 != node2){
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

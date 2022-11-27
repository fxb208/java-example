package leetcode.od2.list;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class Leetcode24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next=new ListNode(2);
//        head.next.next=new ListNode(3);
//        head.next.next.next=new ListNode(4);
        Leetcode24 yb = new Leetcode24();
        yb.swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode();
        ListNode before = res;
        before.next=head;
        ListNode node = head;
        while(node !=null){
            ListNode left = node;
            ListNode right = node.next;
            if(right !=null){
                node = right.next;
                right.next=left;
                left.next=node;
                before.next=right;
                before = left;
            }else{
                break;
            }
        }
        return res.next;
    }

//    public ListNode swapPairs(ListNode head) {
//        ListNode res = new ListNode();
//        ListNode before = res;
//        before.next=head;
//        ListNode node = head;
//        while(node !=null){
//            ListNode left = node;
//            ListNode right = node.next;
//            if(right !=null){
//                ListNode temp = right.next;
//                right.next=left;
//                left.next=temp;
//                node=temp;
//                before.next=right;
//                before = left;
//            }else{
//                break;
//            }
//        }
//        return res.next;
//    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

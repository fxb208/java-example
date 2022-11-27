package leetcode.od2.list;

import java.util.Stack;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Leetcode25 {
    public static void main(String[] args) {
        Leetcode25 yb = new Leetcode25();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);


        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);

        yb.reverseKGroup(head,3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==0 || k==1){
            return head;
        }
        ListNode res = new ListNode();
        ListNode before = res;
        ListNode node = head;
        while(node !=null){
            int idx = 0;
            while(idx<k && node !=null){
                idx++;
                if(idx<k){
                    node = node.next;
                }
            }
            if(idx==k){
                ListNode tail = node;
                ListNode next = node.next;
                node.next=null;
                before.next=reverseList(head);
                before=head;
                node=next;
                head=next;
            }else{
                before.next=head;
                break;
            }

        }
        return res.next;
    }

    public ListNode reverseList(ListNode head){
        ListNode node = head;
        ListNode pre =null;
        while(node !=null){
            ListNode next = node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        return pre;
    }

    public ListNode reverseKGroup_stack(ListNode head, int k) {
        if(k==0 || k==1){
            return head;
        }
        ListNode res = new ListNode();
        ListNode before = res;
        ListNode node = head;
        Stack<ListNode> stack = new Stack<>();
        int idx = 0;
        while(node !=null){
            while(idx<k && node !=null){
                idx++;
                stack.push(node);
                node = node.next;
            }
            idx=0;
            if(stack.size()==k){
                while(!stack.isEmpty()){
                    before.next=stack.pop();
                    before=before.next;
                }
                before.next=null;
            }else{
                Stack<ListNode> temp = new Stack<>();
                while(!stack.isEmpty()){
                    temp.push(stack.pop());
                }
                while(!temp.isEmpty()){
                    before.next=temp.pop();
                    before=before.next;
                }
            }
        }
        return res.next;
    }

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

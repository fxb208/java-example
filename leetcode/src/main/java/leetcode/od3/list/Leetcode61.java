package leetcode.od3.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class Leetcode61 {
    public static void main(String[] args) {
        Leetcode61 yb = new Leetcode61();
        ListNode head = new ListNode(1);
//        head.next=new ListNode(1);
//        head.next.next=new ListNode(2);
        yb.rotateRight(head,0);
    }

    public ListNode rotateRight(ListNode head, int k) {

        List<ListNode> lst = new ArrayList<>();
        ListNode node = head;
        while(node !=null){
            ListNode temp = node.next;
            node.next=null;
            lst.add(node);
            node = temp;
        }
        if(lst.size()==0){
            return head;
        }
        k=k%lst.size();
        ListNode res = new ListNode();
        for(int i=lst.size()-k;i<lst.size();i++){
            if(i==lst.size()-k){
                res.next=lst.get(i);
                node=res.next;
            }else{
                node.next=lst.get(i);
                node=node.next;
            }

        }
        if(k==0){
            node=res;
        }
        for(int i=0;i<lst.size()-k;i++){
            node.next=lst.get(i);
            node = node.next;
        }
        return res.next;
    }

    public ListNode rotateRight_r(ListNode head, int k) {
        ListNode res = new ListNode();
        res.next=head;
        for(int i=0;i<k;i++){
            ListNode temp = new ListNode();
            ListNode node = res.next;
            temp.next=node;
            while(node !=null){
                if(node.next !=null && node.next.next==null){
                    temp.val=node.next.val;
                    res.next=temp;
                    node.next=null;
                    break;
                }else{
                    node = node.next;
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

package leetcode.od.list;

import java.util.LinkedList;
import java.util.List;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Leetcode2 {
    public static void main(String[] args) {
        Leetcode2 yb = new Leetcode2();
        // 2,4,3
        ListNode l1 = new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        // 5,6,4
        ListNode l2 = new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        yb.addTwoNumbers(l1,l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean carry = false;
        ListNode result = new ListNode();
        ListNode res = result;
        while(l1 !=null || l2 !=null){
            int sum=0;
            if(carry){
                sum=1;
            }
            if(l1==null){
                sum += l2.val;
                l2=l2.next;
            }else if(l2==null){
                sum += l1.val;
                l1=l1.next;
            }else{
                sum +=l1.val;
                sum +=l2.val;
                l1=l1.next;
                l2=l2.next;
            }
            if(sum>9){
                res.next=new ListNode(sum-10);
                carry=true;
            }else{
                res.next=new ListNode(sum);
                carry=false;
            }
            res=res.next;
        }
        if(carry){
            res.next = new ListNode(1);
        }
        return result.next;
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        LinkedList<Integer> lst1 = new LinkedList<>();
//        LinkedList<Integer> lst2 = new LinkedList<>();
//        while(l1 !=null){
//            lst1.addFirst(l1.val);
//            l1=l1.next;
//        }
//        while(l2 !=null){
//            lst2.addFirst(l2.val);
//            l2=l2.next;
//        }
//        boolean carry = false;
//
//        ListNode result = new ListNode();
//        ListNode res = result;
//        while(lst1.size() >0 || lst2.size() >0){
//            if(lst1.size()==0){
//                if(carry){
//                    if(lst2.peekLast()+1>9){
//                        res.next=new ListNode(0);
//                    }else{
//                        res.next=new ListNode(lst2.pollLast()+1);
//                        carry = false;
//                    }
//                }else{
//                    res.next=new ListNode(lst2.pollLast());
//                }
//            }else if(lst2.size()==0){
//                if(carry){
//                    if(lst1.peekLast()+1>9){
//                        res.next=new ListNode(0);
//                    }else{
//                        res.next=new ListNode(lst1.pollLast()+1);
//                        carry = false;
//                    }
//                }else{
//                    res.next=new ListNode(lst1.pollLast());
//                }
//            }else{
//                if(carry){
//                    if(lst1.peekLast() + lst2.peekLast() + 1>9){
//                        res.next=new ListNode(lst1.pollLast() + lst2.pollLast()+1-10);
//                        carry=true;
//                    }else{
//                        res.next=new ListNode(lst1.pollLast() + lst2.pollLast()+1);
//                        carry=false;
//                    }
//                }else{
//                    if(lst1.peekLast() + lst2.peekLast()>9){
//                        res.next=new ListNode(lst1.pollLast() + lst2.pollLast()-10);
//                        carry=true;
//                    }else{
//                        res.next=new ListNode(lst1.pollLast() + lst2.pollLast());
//                        carry=false;
//                    }
//
//                }
//            }
//            res=res.next;
//        }
//        if(carry){
//            res.next = new ListNode(1);
//        }
//        return result.next;
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

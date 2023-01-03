package leetcode.od3.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class Leetcode234 {
    public static void main(String[] args) {
        Leetcode234 yb = new Leetcode234();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        yb.isPalindrome(head);
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> lst = new ArrayList<>();
        while(head !=null){
            lst.add(head.val);
            head = head.next;
        }
        for(int i=0;i<lst.size()/2;i++){
            if(!lst.get(i).equals(lst.get(lst.size()-1-i))){
                return false;
            }
        }
        return true;
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

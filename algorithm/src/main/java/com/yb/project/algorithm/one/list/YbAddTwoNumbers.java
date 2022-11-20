package com.yb.project.algorithm.one.list;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 445. 两数相加 II
 * @author fxb20
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbAddTwoNumbers {
	
	public static void main(String[] args) {
		YbAddTwoNumbers yb=new YbAddTwoNumbers();
		ListNode head1=new ListNode(1);
		ListNode l1=new ListNode(1,head1);
		
		ListNode l2=new ListNode(2);
		ListNode res=yb.addTwoNumbers(l1, l2);
		System.out.println(res.val);
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	Deque<Integer> lst1=new LinkedList<Integer>();
    	Deque<Integer> lst2=new LinkedList<Integer>();
    	ListNode node1=l1;
    	while(node1 !=null) {
    		lst1.push(node1.val);
    		node1=node1.next;
    	}
    	ListNode node2=l2;
    	while(node2 !=null) {
    		lst2.push(node2.val);
    		node2=node2.next;
    		
    	}
    	boolean carry=false;
    	ListNode res=null;
    	while(!lst1.isEmpty() || !lst2.isEmpty()) {
    		int val=0;
    		if(lst1.isEmpty()) {
    			val=lst2.poll();
    		}else if(lst2.isEmpty()) {
    			val=lst1.poll();
    		}else {
    			val=lst1.poll()+lst2.poll();
    		}
    		if(carry) {
    			val++;
    		}
    		if(val>9) {
    			carry=true;
    			val=val%10;
    		}else {
    			carry=false;
    		}
    		ListNode cur=new ListNode(val,res);
    		res=cur;
    		
    	}
    	if(carry) {
    		res=new ListNode(1,res);
    	}
    	return res;
    	
    }
	
    /**
     * low版本
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
    	ArrayList<ListNode> lst1=new ArrayList<ListNode>();
    	ArrayList<ListNode> lst2=new ArrayList<ListNode>();
    	ListNode node1=l1;
    	while(node1 !=null) {
    		lst1.add(node1);
    		node1=node1.next;
    	}
    	ListNode node2=l2;
    	while(node2 !=null) {
    		lst2.add(node2);
    		node2=node2.next;
    		
    	}
    	int len1=lst1.size();
    	int len2=lst2.size();
    	

    	LinkedList<Integer> lst=new LinkedList<Integer>();
    	boolean carry=false;
    	while(len1>0 || len2>0) {
    		int val=0;
    		if(len1==0) {
    			val=(lst2.get(len2-1).val);
    			len2--;
    		}else if(len2==0) {
    			val=lst1.get(len1-1).val;
    			len1--;
    		}else {
    			val=lst1.get(len1-1).val+lst2.get(len2-1).val;
    			len2--;
    			len1--;
    		}
    		if(carry) {
    			val++;
    		}
    		if(val>9) {
    			carry=true;
    			lst.push(val%10);
    		}else {
    			carry=false;
    			lst.push(val);
    		}
    	}
    	if(carry) {
    		lst.push(1);
    	}
    	ListNode res=new ListNode(0, null);
    	ListNode head=res;
    	while(lst.peek() !=null) {
    		head.next=new ListNode(lst.poll());
    		head=head.next;
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

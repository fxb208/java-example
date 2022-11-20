package com.yb.project.algorithm.one.doublepointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表相交
 * @author fxb20
 *
 */
public class YbGetIntersectionNode {
	
	/**
	 * 双指针法
	 * @param headA
	 * @param headB
	 * @return
	 * 
	 */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA==null || headB==null) {
    		return null;
    	}
    	ListNode first=headA;
    	ListNode second=headB;
    	
    	while(first !=second) {
    		first=first.next==null ? headB :first.next;
    		second=second.next==null ? headA:second.next;
    	}
    	//first=null 或者first=相交的节点
        return first;
    }
	
	/**
	 * hash
	 * @param headA
	 * @param headB
	 * @return
	 */
    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
    	Set<ListNode> set = new HashSet<ListNode>();
    	while(headA !=null) {
    		set.add(headA);
    		headA=headA.next;
    	}
    	while(headB !=null) {
    		if(set.contains(headB)) {
    			return headB;
    		}
    		headB=headB.next;
    	}
        return null;
    }
}

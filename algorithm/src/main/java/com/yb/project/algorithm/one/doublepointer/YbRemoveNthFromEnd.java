package com.yb.project.algorithm.one.doublepointer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 19. 删除链表的倒数第 N 个结点
 * @author fxb20
 * 
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 */
public class YbRemoveNthFromEnd {
	
	/**
	 * stack
	 * @param head
	 * @param n
	 * @return
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	Deque<ListNode> stack=new LinkedList<ListNode>();
    	ListNode node=new ListNode(0,head);
    	ListNode cur = node;
    	while(cur !=null) {
    		stack.push(cur);
    		cur=cur.next;
    	}
    	for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = node.next;
    	return ans;
    }
}

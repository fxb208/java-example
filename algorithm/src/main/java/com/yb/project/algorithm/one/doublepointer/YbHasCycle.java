package com.yb.project.algorithm.one.doublepointer;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 141. 环形链表
 * @author fxb20
 * 
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 *
 */
public class YbHasCycle {
	
	/**
	 * 双指针法  环形链表，快指针一定追上慢指针
	 * @param head
	 * @return
	 */
    public boolean hasCycle(ListNode head) {
    	if(head==null || head.next==null) {
    		return false;
    	}
    	ListNode slow=head;
    	ListNode fast=head.next;
    	while(slow !=fast) {
    		if(fast==null || fast.next==null) {
    			return false;
    		}
    		fast=fast.next.next;
    		slow=slow.next;
    	}
        return true;
    }
	
	/**
	 * hash算法
	 * @param head
	 * @return
	 */
    public boolean hasCycle0(ListNode head) {
    	Set<ListNode> set=new HashSet<ListNode>();
    	while(head !=null) {
    		if(set.contains(head)) {
    			return true;
    		}else {
    			set.add(head);
    		}
    		head=head.next;
    	}
        return false;
    }
}

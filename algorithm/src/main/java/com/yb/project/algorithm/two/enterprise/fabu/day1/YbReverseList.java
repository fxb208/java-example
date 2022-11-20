package com.yb.project.algorithm.two.enterprise.fabu.day1;

import java.util.LinkedList;

/**
 * 206. 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class YbReverseList {
  public ListNode reverseList(ListNode head) {
    LinkedList<ListNode> listNodes = new LinkedList<>();
    ListNode node = head;
    while (node != null) {
      listNodes.add(node);
      node = node.next;
    }
    ListNode result = listNodes.pollLast();
    if (result == null) {
      return head;
    }
    node = result;
    while (listNodes.peekLast() != null) {
      node.next = listNodes.pollLast();
      node = node.next;
    }
    node.next = null;
    return result;
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}



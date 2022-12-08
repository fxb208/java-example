package leetcode.od3.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 */
public class Leetcode109 {
    public static void main(String[] args) {
        Leetcode109 yb = new Leetcode109();
        // -10,-3,0,5,9
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        yb.sortedListToBST(head);
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> lst = new ArrayList<>();
        while(head !=null){
            lst.add(head.val);
            head=head.next;
        }
        TreeNode res = buildTree(lst,0,lst.size()-1);
        return res;
    }

    public TreeNode buildTree(List<Integer> lst,int left,int right){
        if(left>right){
            return null;
        }
        int middle = (left + right)/2;
        TreeNode node = new TreeNode(lst.get(middle));
        node.left=buildTree(lst,left,middle-1);
        node.right=buildTree(lst,middle+1,right);
        return node;
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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

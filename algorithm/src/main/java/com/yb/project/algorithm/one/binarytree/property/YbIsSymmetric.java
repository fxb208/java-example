package com.yb.project.algorithm.one.binarytree.property;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 101. 对称二叉树
 * @author fxb20
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class YbIsSymmetric {
	
	public boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return true;
		}
		return check(root.left, root.right);
	}
	
	public boolean check(TreeNode left,TreeNode right) {
		if(left==null && right==null) {
			return true;
		}
		if(left==null || right==null) {
			return false;
		}
		return left.val==right.val && check(left.left,right.right) && check(left.right,right.left);	}
	
	
	public boolean isSymmetric0(TreeNode root) {
		return check(root, root);
	}
	
	public boolean check0(TreeNode left,TreeNode right) {
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(left);
		queue.offer(right);
		while(!queue.isEmpty()) {
			TreeNode node1=queue.poll();
			TreeNode node2=queue.poll();
			if(node1 ==null && node2 ==null) {
				continue;
			}
			if(node1==null || node2==null || node1.val !=node2.val) {
				return false;
			}
			queue.offer(left.left);
			queue.offer(right.right);
			queue.offer(left.right);
			queue.offer(right.left);
		}
		return true;
	}
}

package com.yb.project.algorithm.one.binarytree.property;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 104. 二叉树的最大深度
 * @author fxb20
 *
 */
public class YbMaxDepth {
	
	/**
	 * 广度优先算法
	 * @param root
	 * @return
	 */
	public int maxDepth0(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int dept=0;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			dept++;
			int size=queue.size();
			for(int i=0;i<size;i++) {
				TreeNode node=queue.poll();
				if(node.left !=null) {
					queue.offer(node.left);
				}
				if(node.right !=null) {
					queue.offer(node.right);
				}
			}
		}
		return dept;
	}
	
	/**
	 * 深度优先算法
	 * @param root
	 * @return
	 */
    public int maxDepth(TreeNode root) {
		if(root==null) {
    		return 0;
    	}
    	return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

}

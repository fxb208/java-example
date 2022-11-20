package com.yb.project.algorithm.one.binarytree.property;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 111. 二叉树的最小深度
 * @author fxb20
 * 
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */
public class YbMinDepth {
	
	/**
	 * 深度优先算法
	 * @param root
	 * @return
	 */
    public int minDepth(TreeNode root) {
       	if(root==null) {
    		return 0;
    	}
    	 // null节点不参与比较
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        // null节点不参与比较
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }
    	return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
    
    /**
     * 广度优先算法
     * @param root
     * @return
     */
    public int minDepth0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int dept=0;
        while (!queue.isEmpty()) {
        	int size=queue.size();
        	dept++;
        	for(int i=0;i<size;i++) {
        		TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return dept;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }	
        	}
        }
        return dept;
    }
}

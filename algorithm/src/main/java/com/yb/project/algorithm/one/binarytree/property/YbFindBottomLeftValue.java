package com.yb.project.algorithm.one.binarytree.property;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 513. 找树左下角的值
 * @author fxb20
 * 
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * 
 * 输入: root = [2,1,3]
输出: 1
 *
 */
public class YbFindBottomLeftValue {
	
	public static void main(String[] args) {
		YbFindBottomLeftValue yb=new YbFindBottomLeftValue();
		TreeNode left=new TreeNode(1);
		TreeNode right=new TreeNode(3);
		TreeNode root=new TreeNode(2,left,right);
		yb.findBottomLeftValue(root);
	}
	
    public int findBottomLeftValue(TreeNode root) {   	
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	if(root !=null) {
    		queue.offer(root);	
    	}
    	int res=root.val;
    	while(!queue.isEmpty()) {
    		int size=queue.size();
    		for(int i=0;i<size;i++) {
    			TreeNode node=queue.poll();
    			if(i==0) {
    				res=node.val;
    			}
    			if(node.left!=null) {
    				queue.offer(node.left);
    			}
    			if(node.right!=null) {
    				queue.offer(node.right);
    			}
    		}
    	}
    	return res;
    }
}

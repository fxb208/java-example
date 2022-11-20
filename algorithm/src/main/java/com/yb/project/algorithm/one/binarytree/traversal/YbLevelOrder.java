package com.yb.project.algorithm.one.binarytree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 102. 二叉树的层序遍历
 * @author fxb20
 *	给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 */
public class YbLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	if(root==null) {
    		return res;
    	}
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()) {
    		int size=queue.size();
    		List<Integer> lst=new ArrayList<Integer>();
    		for(int i=0;i<size;i++) {
    			TreeNode node=queue.poll();
    			lst.add(node.val);
    			if(node.left != null) {
    				queue.offer(node.left);
    			}
    			if(node.right != null) {
    				queue.offer(node.right);
    			}
    		}
    		res.add(lst);
    	}
    	return res;
    }
}

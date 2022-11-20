package com.yb.project.algorithm.one.binarytree.property;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 257. 二叉树的所有路径
 * @author fxb20
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class YbBinaryTreePaths {
    public List<String> binaryTreePaths0(TreeNode root) {
    	List<String> res =new LinkedList<String>();
    	Queue<TreeNode> queue=new LinkedList<TreeNode>(); 
    	if(root ==null) {
    		return res;
    	}
    	queue.add(root);
    	while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				TreeNode node=queue.poll();
				if(node.left !=null) {
					queue.offer(node.left);
				}
				if(node.right !=null) {
					queue.offer(node.right);
				}
				if(node.left==null && node.right==null) {
					
				}
			}
    	}
    	return res;
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res =new LinkedList<String>();
    	List<Integer> lst=new ArrayList<Integer>();
    	lst.add(root.val);
    	path(res,lst,root);
    	return res;
    }
    
    public void path(List<String> res,List<Integer> lst,TreeNode root) {
    	if(root==null) {
    		return;
    	}
    	if(root.left ==null && root.right==null) {
    		StringBuilder sb=new StringBuilder();
    		for(int i=0;i<lst.size();i++) {
    			if(sb.length() >0) {
    				sb.append("->");
    			}
    			sb.append(lst.get(i));
    		}
    		res.add(sb.toString());
    	}
    	if(root.left !=null) {
    		lst.add(root.left.val);
    		path(res,lst,root.left);
    		lst.remove(lst.size()-1);
    	}
    	if(root.right !=null) {
    		lst.add(root.right.val);
    		path(res,lst,root.right);
    		lst.remove(lst.size()-1);
    	}
    }
}

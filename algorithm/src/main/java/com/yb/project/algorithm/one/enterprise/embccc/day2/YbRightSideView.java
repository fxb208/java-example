package com.yb.project.algorithm.one.enterprise.embccc.day2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * @author fxb20
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 输入: [1,null,3]
 * 输出: [1,3]
 */
public class YbRightSideView {
	
	/**
	 * 广度优先算法
	 * @param root
	 * @return
	 */
    public List<Integer> rightSideView(TreeNode root) {
    	ArrayList<Integer> lst=new ArrayList<Integer>();
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	if(root!=null) {
    		queue.offer(root);
    	}
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
    			if(i==size) {
    				lst.add(node.val);
    			}
    		}
    	}
    	return lst;
    }
    
    /**
     * 深度优先算法
     * @param root
     * @return
     */
    public List<Integer> rightSideView0(TreeNode root) {
    	ArrayList<Integer> lst=new ArrayList<Integer>();
    	dfs(root,lst,0);
    	return lst;
    }
    
    public void dfs(TreeNode root,List<Integer> list,int deep) {
    	if(root !=null) {
    		if(list.size()==deep) {
        		list.add(root.val);
        	}
    		deep++;
        	dfs(root.right,list,deep);	
        	dfs(root.left,list,deep);
    	}
    }
    
	public class TreeNode {
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

package com.yb.project.algorithm.one.tree.binarytree;

import java.util.LinkedList;
import java.util.List;





/**
 * leecode 998
 * @author fxb20
 *
 */
public class YbInsertIntoMaxTree {

	public TreeNode insertIntoMaxTree(TreeNode root, int val) {
		
		LinkedList<Integer> list=new LinkedList<Integer>();
		inorderTreeWalk(root,list);
		list.add(val);
		int[] nums=new int[list.size()];
		for(int i=0;i<nums.length;i++) {
			nums[i]=list.get(i);
		}
		TreeNode treeNode=this.constructMaximumBinaryTree(nums,0, nums.length);
		
		return treeNode;
	}
	
	public TreeNode constructMaximumBinaryTree(int[] nums,int start,int end) {
		if(start==end) {
			return null;
		}
		int maxIndex=start;
		for(int i=start+1;i<end;i++) {
			if(nums[i]>nums[maxIndex]) {
				maxIndex=i;
			}
		}
		TreeNode left=constructMaximumBinaryTree(nums, start,maxIndex);
		TreeNode right=constructMaximumBinaryTree(nums, maxIndex+1,end);
		TreeNode root=new TreeNode(nums[maxIndex], left, right);
		return root;
	}
	
    public void inorderTreeWalk(TreeNode treeNode,List<Integer> list) {
    	if(treeNode !=null) {
    		inorderTreeWalk(treeNode.left,list);
    		list.add(treeNode.val);
    		inorderTreeWalk(treeNode.right,list);
    		
    	}
    }
	
}

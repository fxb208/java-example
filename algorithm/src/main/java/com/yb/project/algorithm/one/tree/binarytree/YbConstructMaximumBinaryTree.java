package com.yb.project.algorithm.one.tree.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 998. 最大二叉树 II
 * @author fxb20
 *
 */
public class YbConstructMaximumBinaryTree {
	public static void main(String[] args) {
		YbConstructMaximumBinaryTree maximumBinaryTree=new YbConstructMaximumBinaryTree();
		int[] nums=new int[] {3,2,1,6,0,5};
		TreeNode treeNode=maximumBinaryTree.constructMaximumBinaryTree(nums);
		List<Integer> list=new LinkedList<Integer>();
		maximumBinaryTree.inorderTreeWalk(treeNode,list);
		list.stream().forEach(e->{
			System.out.println(e);
		});
	}
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode root=constructMaximumBinaryTree(nums, 0, nums.length);
		return root;
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

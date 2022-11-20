package com.yb.project.algorithm.one.binarytree.transform;

/**
 * leetcode 226. 翻转二叉树
 * @author fxb20
 * 
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class YbInvertTree {
	
    public TreeNode invertTree(TreeNode root) {
    	dfs(root);
    	return root;
    }
    
	/**
	 * 深度优先遍历
	 * @param root
	 * @return
	 */
    public void dfs(TreeNode root) {
    	if(root ==null) {
    		return;
    	}
    	TreeNode node=root.left;
    	root.left=root.right;
    	root.right=node;
    	dfs(root.left);
    	dfs(root.right);
    }
}

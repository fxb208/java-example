package com.yb.project.algorithm.one.tree.binarytree;


/**
 * leecode 110. 平衡二叉树
 * @author fxb20
 * 
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 */
public class YbIsBalanced {
	
    public boolean isBalanced(TreeNode root) {
    	if(root==null) {
    		return true;
    	}
    	if(root.left ==null && root.right ==null) {
    		return true;
    	}
    	boolean a=true;
    	boolean b=true;
    	if(root.left !=null) {
    		a=isBalanced(root.left);   //左子树平衡
    	}
    	if(root.right !=null) {
    		b=isBalanced(root.right);  //右子树平衡
    	}
    	if(a && b) { //左右子树高度差小于1
    		return Math.abs(getTreeHigh(root.left)-getTreeHigh(root.right))<=1;
    		
    	}
    	return false;
    	
    }
    
    public int getTreeHigh(TreeNode root) {
    	if(root==null) {
    		return 0;
    	}
    	return Math.max(getTreeHigh(root.left), getTreeHigh(root.right))+1;
    }
    
    /**
     * [1,2,2,3,3,null,null,4,4]
     */
}

package com.yb.project.algorithm.one.binarytree.property;


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
	
	/**
	 * 平衡二叉树满足两个条件
	 * 	1，左树平衡，右树平衡
	 *  2，左树高度与右树高度相差为1
	 * @param root
	 * @return
	 */
    public boolean isBalanced(TreeNode root) {
    	if(root==null) {
    		return true;
    	}
    	return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left)-depth(root.right))<=1;

    }
    
    public int depth(TreeNode root) {
    	if(root==null) {
    		return 0;
    	}
    	return Math.max(depth(root.left), depth(root.right))+1;
    }
    
    /**
     * [1,2,2,3,3,null,null,4,4]
     */
}

package com.yb.project.algorithm.one.tree.binarysearchtree;



/**
 * leecode 98.验证二叉搜索树
 * @author fxb20
 * 
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class YbIsValidBST {
	
	public static void main(String[] args) {
		TreeNode left=new TreeNode(1);
		TreeNode right=new TreeNode(3);
		TreeNode root=new TreeNode(2,left,right);
		YbIsValidBST yb=new YbIsValidBST();
		boolean result=yb.isValidBST(root);
		System.out.println(result);
	}

    public boolean isValidBST(TreeNode root) {
    	return inorderTreeWalk(root);
    }
    TreeNode pre=null;
    public boolean inorderTreeWalk(TreeNode root) {
    	if(root ==null) {
    		return true;
    	}
    	if(!inorderTreeWalk(root.left)) {
    		return false;
    	}
    	if(pre==null) {
    		pre=root;
    	}else if(pre.val>=root.val) {
    		return false;
        }
    	pre=root;
    	return(inorderTreeWalk(root.right));
    }
}

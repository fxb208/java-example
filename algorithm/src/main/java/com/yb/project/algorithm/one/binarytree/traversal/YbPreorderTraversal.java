package com.yb.project.algorithm.one.binarytree.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 144. 二叉树的前序遍历
 * @author fxb20
 *	
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 *
 */
public class YbPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> res=new ArrayList<Integer>();
    	preorderTraversal(res,root);
    	return res;

    }
    
    public void preorderTraversal(List<Integer> res,TreeNode root) {
    	if(root !=null) {
    		res.add(root.val);
    		preorderTraversal(res,root.left);
    		preorderTraversal(res,root.right);
    	}
    }
    
}

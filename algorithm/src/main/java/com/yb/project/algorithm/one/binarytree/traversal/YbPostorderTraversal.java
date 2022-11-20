package com.yb.project.algorithm.one.binarytree.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 145. 二叉树的后序遍历
 * @author fxb20
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 */
public class YbPostorderTraversal {
	
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res=new ArrayList<Integer>();
    	preorderTraversal(res,root);
    	return res;
    }
    
    public void preorderTraversal(List<Integer> res,TreeNode root) {
    	if(root !=null) {
    		preorderTraversal(res,root.left);
    		preorderTraversal(res,root.right);
    		res.add(root.val);
    	}
    }
}

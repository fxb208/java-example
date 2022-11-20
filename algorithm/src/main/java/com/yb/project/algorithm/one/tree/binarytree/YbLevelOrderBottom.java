package com.yb.project.algorithm.one.tree.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * leecode 107
 * @author fxb20
 *
 */
public class YbLevelOrderBottom {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<TreeNode> lstTreeNode=new LinkedList<TreeNode>();
    	if(root !=null) {
    		lstTreeNode.add(root);
    	}
    	List<TreeNode> lstChildrenTreeNode=null;
    	LinkedList<List<Integer>> list=new LinkedList<List<Integer>>();
    	while(lstTreeNode.size()>0) {
    		lstChildrenTreeNode=new LinkedList<TreeNode>();
    		List<Integer> lstVal=new LinkedList<Integer>();
    		levelOrder(lstVal,lstTreeNode,lstChildrenTreeNode);
    		lstTreeNode=lstChildrenTreeNode;
    		list.addFirst(lstVal);
    	}
    	return list;
    }
    
    public void levelOrder(List<Integer> lstVal,List<TreeNode> lstTreeNode,List<TreeNode> lstChildrenTreeNode) {
    	for(int i=0;i<lstTreeNode.size();i++) {
    		TreeNode treeNode=lstTreeNode.get(i);
    		lstVal.add(treeNode.val);
    		if(treeNode.left !=null) {
    			lstChildrenTreeNode.add(treeNode.left);
    		}
    		if(treeNode.right !=null) {
    			lstChildrenTreeNode.add(treeNode.right);
    		}
    	}
    }
}

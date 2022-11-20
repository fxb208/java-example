package com.yb.project.algorithm.one.tree.binarytree;

import java.util.ArrayList;
import java.util.List;


/**
 * leecode 113. 路径总和
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * 
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * @author fxb20
 *
 */
public class YbPathSum {
	
	List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
 
    	dfs(root,targetSum);
        return res;
    }
    
    public void dfs(TreeNode root, int targetSum) {
    	if(root==null) {
    		return;
    	}
    	path.add(root.val);
    	if(root.left==null && root.right==null && root.val==targetSum) {
    		res.add(new ArrayList<Integer>(path));
    	}
    	pathSum(root.left,targetSum-root.val);
    	pathSum(root.right,targetSum-root.val);
    	//回溯
        path.remove(path.size()-1);
    }
}

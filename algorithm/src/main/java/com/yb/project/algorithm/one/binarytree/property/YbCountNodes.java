package com.yb.project.algorithm.one.binarytree.property;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 222. 完全二叉树的节点个数
 * @author fxb20
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbCountNodes {
	/**
	 * 广度遍历
	 * @param root
	 * @return
	 */
    public int countNodes(TreeNode root) {
    	int res=0;
    	if(root ==null) {
    		return res;
    	}
    	Deque<TreeNode> deque=new LinkedList<TreeNode>();
    	deque.offer(root);
    	while(!deque.isEmpty()) {
    		int size=deque.size();
    		res+=size;
    		for(int i=0;i<size;i++) {
    			TreeNode node=deque.poll();
    			if(node.left !=null) {
    				deque.offer(node.left);
    			}
    			if(node.right !=null) {
    				deque.offer(node.right);
    			}
    		}
    	}
    	return res;
    }
    
	/**
	 * 深度遍历
	 * @param root
	 * @return
	 */
    public int dfs(TreeNode root) {
    	if(root ==null) {
    		return 0;
    	}
		if(root.left == null && root.right != null) {
			return dfs(root.right)+1;
		}
		if(root.right == null && root.left != null) {
			return dfs(root.left)+1;
		}
    	return dfs(root.left)+dfs(root.right)+1;
    }
}

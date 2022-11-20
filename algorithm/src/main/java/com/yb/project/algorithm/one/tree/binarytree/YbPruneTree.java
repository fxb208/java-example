package com.yb.project.algorithm.one.tree.binarytree;

/**
 * leetcode 814. 二叉树剪枝
 * @author fxb20
 * 
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 * 
 * 输入：root = [1,null,0,0,1]
 * 输出：[1,null,0,null,1]
 * 解释：
 * 只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-pruning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbPruneTree {
	
    public TreeNode pruneTree(TreeNode root) {
    	del(root);
    	return root;
    }
    
    public boolean del(TreeNode root) {
    	if(root !=null) {
    		if(del(root.left)) {
    			root.left=null;
    		}
    		if(del(root.right)) {
    			root.right=null;
    		}
    		if(root.left==null && root.right==null && root.val==0) {
    			return true;
    		}
    		return false;
    	}
    	return true;
    }
    
}

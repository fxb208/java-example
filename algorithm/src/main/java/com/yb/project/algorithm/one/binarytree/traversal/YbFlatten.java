package com.yb.project.algorithm.one.binarytree.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 114. 二叉树展开为链表
 * @author fxb20
 *	给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbFlatten {
	
    public void flatten(TreeNode root) {
    	List<TreeNode> res=new ArrayList<TreeNode>();
    	preorderTraversal(res,root);
    	for(int i=1;i<res.size();i++) {
    		TreeNode pre=res.get(i-1);
    		TreeNode cur=res.get(i);
    		pre.left=null;
    		pre.right=cur;
    	}
    }
    
    public void preorderTraversal(List<TreeNode> list,TreeNode root) {
    	if(root !=null) {
    		list.add(root);
    		preorderTraversal(list,root.left);
    		preorderTraversal(list,root.right);
    	}
    }
}

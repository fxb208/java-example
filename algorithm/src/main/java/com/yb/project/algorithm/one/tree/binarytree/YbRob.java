package com.yb.project.algorithm.one.tree.binarytree;

/**
 * leecode 337. 打家劫舍 III
 * 
 * 	小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * 
 * 
 * @author fxb20
 *
 */
public class YbRob {
	
	/**
	 *                3
	 *            2       3
	 *            3       1    
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode treeNode1=new TreeNode(3);
		TreeNode left=new TreeNode(2, null, treeNode1);
		
		TreeNode treeNode2=new TreeNode(1);
		TreeNode right=new TreeNode(3, null, treeNode2);
		TreeNode root=new TreeNode(3, left, right);
		
		YbRob yb=new YbRob();
		yb.rob(root);
	}
	
	/**
	 * https://blog.csdn.net/weixin_44190665/article/details/121131697
	 * https://blog.csdn.net/qq_40840749/article/details/116236114
	 * @param nums
	 * @return
	 */
	public int rob(TreeNode root) {
		int[] result= robdeep(root);
		return Math.max(result[0],result[1]);	
	}
	
	public int[] robdeep(TreeNode treeNode) {
		if(treeNode==null) {
			return new int[] {0,0};
		}
		int[] leftResult=robdeep(treeNode.left);
		int[] rightResult=robdeep(treeNode.right);
		//当前节点不偷
		int cur=Math.max(leftResult[0], leftResult[1])+Math.max(rightResult[0], rightResult[1]);		
		//偷当前节点
		int cur2=treeNode.val+leftResult[0]+rightResult[0];
		return new int[] {cur,cur2};
	}

}

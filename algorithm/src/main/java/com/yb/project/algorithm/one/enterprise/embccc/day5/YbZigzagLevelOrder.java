package com.yb.project.algorithm.one.enterprise.embccc.day5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * @author fxb20
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbZigzagLevelOrder {
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Deque<TreeNode> deque = new LinkedList<TreeNode>();  //奇数行
		if (root != null) {
			deque.offer(root);
		}
		int deep=1;
		while (!deque.isEmpty()) {
			LinkedList<Integer> lst = new LinkedList<Integer>();
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = deque.poll();
				if(deep%2==1) {//从左往右
					lst.add(node.val);
				}else { //从右往左
					lst.push(node.val);				}
				if (node.left != null) {
					deque.offer(node.left);
				}
				if (node.right != null) {
					deque.offer(node.right);
				}
			}
			deep++;
			result.add(lst);
		}
		return result;
	}

	/**
	 * 很low
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder0(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Deque<TreeNode> deque1 = new LinkedList<TreeNode>();  //奇数行
		Deque<TreeNode> deque2 = new LinkedList<TreeNode>();  //偶数行
		if (root != null) {
			deque1.offer(root);
		}
		int deep=1;
		while (!deque1.isEmpty() || !deque2.isEmpty()) {
			deep++;
			List<Integer> lst = new LinkedList<Integer>();
			int size = deque1.size()>0?deque1.size():deque2.size();
			for (int i = 0; i < size; i++) {
				if(deep%2==0) {//从右往左
					TreeNode node = deque1.poll();
					lst.add(node.val);
					if (node.left != null) {
						deque2.push(node.left);
					}
					if (node.right != null) {
						deque2.push(node.right);
					}
					
				}else { //从左往右
					TreeNode node = deque2.poll();
					lst.add(node.val);
					if (node.right != null) {
						deque1.push(node.right);
					}
					if (node.left != null) {
						deque1.push(node.left);
					};

				}
			}
			result.add(lst);
		}
		return result;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}

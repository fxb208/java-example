package leetcode.od.tree;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class JZ55II {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return Math.abs(deep(root.left)-deep(root.right))<2 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int deep(TreeNode node){
        if(node==null){
            return 0;
        }else{
            return Math.max(deep(node.left),deep(node.right))+1;
        }
    }

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

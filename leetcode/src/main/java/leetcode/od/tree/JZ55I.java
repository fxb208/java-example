package leetcode.od.tree;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 */
public class JZ55I {
    public int maxDepth(TreeNode root) {
        return deep(root);
    }

    public int deep(TreeNode node){
        if (node==null){
            return 0;
        }else{
            return Math.max(deep(node.left),deep(node.right))+1;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

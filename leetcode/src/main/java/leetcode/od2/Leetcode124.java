package leetcode.od2;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个
 * 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class Leetcode124 {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        simplePath(root, res);
        return res[0];
    }

    public int simplePath(TreeNode root, int[] res) {
        if(root == null){
            return 0;
        }
        int left = Math.max(simplePath(root.left,res),0);
        int right = Math.max(simplePath(root.right,res),0);
        res[0]=Math.max(left+right+root.val,res[0]);
        return Math.max(left,right)+root.val;
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

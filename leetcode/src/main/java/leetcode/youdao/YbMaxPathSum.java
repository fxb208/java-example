package leetcode.youdao;

/**
 * 树
 * 深度优先搜索
 * 动态规划
 * 124. 二叉树中的最大路径和
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
 */
public class YbMaxPathSum {
    int sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        simplePath(root);
        return sum;
    }

    public int simplePath(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(simplePath(node.left),0);
        int right = Math.max(simplePath(node.right),0);
        int temp=left+right+ node.val;
        sum=Math.max(temp,sum);
        return node.val+Math.max(left,right);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}

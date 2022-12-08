package leetcode.od3.tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums,0,nums.length-1);
    }

    public TreeNode makeTree(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int middle = left+(right-left)/2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = makeTree(nums,left,middle-1);
        node.right = makeTree(nums,middle+1,right);
        return node;
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

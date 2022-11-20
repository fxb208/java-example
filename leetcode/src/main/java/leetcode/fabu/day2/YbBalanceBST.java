package leetcode.fabu.day2;



/**
 * 1382. 将二叉搜索树变平衡
 * https://leetcode.cn/problems/balance-a-binary-search-tree/
 */
public class YbBalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        return null;
    }

    class TreeNode {
        int val;
        YbKthSmallest.TreeNode left;
        YbKthSmallest.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, YbKthSmallest.TreeNode left, YbKthSmallest.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

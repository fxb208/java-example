package leetcode.od3.tree;


/**
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 */
public class Leetcode129 {
    public static void main(String[] args) {
        Leetcode129 yb = new Leetcode129();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(yb.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] res = new int[1];
        dfs(res,new StringBuilder(),root);
        return res[0];
    }

    public void dfs(int[] res,StringBuilder sb, TreeNode root){
       if(root.left ==null && root.right==null){
           res[0]+=Integer.valueOf(sb.append(root.val).toString());
           sb.delete(sb.length()-1,sb.length());
           return;
       }
       if(root.left !=null){
           sb.append(root.val);
           dfs(res,sb,root.left);
           sb.delete(sb.length()-1,sb.length());
       }
       if(root.right !=null){
           sb.append(root.val);
           dfs(res,sb,root.right);
           sb.delete(sb.length()-1,sb.length());
       }

    }

    public static class TreeNode {
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

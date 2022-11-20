package leetcode.od.tree;

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

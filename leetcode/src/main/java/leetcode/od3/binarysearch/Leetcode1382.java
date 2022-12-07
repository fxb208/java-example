package leetcode.od3.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. 将二叉搜索树变平衡
 *
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 * 如果有多种构造方法，请你返回任意一种。
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 */
public class Leetcode1382 {

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<>();
        morder(root,lst);
        return makeTree(lst,0,lst.size()-1);
    }

    public TreeNode makeTree(ArrayList<Integer> lst, int left, int right){
        if(left<=right){
            int middle = (left+right)/2;
            TreeNode root = new TreeNode(lst.get(middle));
            root.left = makeTree(lst,left,middle-1);
            root.right = makeTree(lst,middle+1,right);
            return root;
        }
        return null;
    }

    public void morder(TreeNode root, List<Integer> lst){
        if(root !=null){
            morder(root.left,lst);
            lst.add(root.val);
            morder(root.right,lst);;
        }
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

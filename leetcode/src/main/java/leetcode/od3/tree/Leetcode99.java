package leetcode.od3.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树 。
 */
public class Leetcode99 {
    public static void main(String[] args) {
        Leetcode99 yb = new Leetcode99();
        // [1,3,null,null,2]
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(3);
        root.left.right=new TreeNode(2);
        yb.recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        middleOrder(root,lst);
        int left = -1;
        int right = -1;
        for(int i=1;i<lst.size();i++){
            if(lst.get(i)< lst.get(i-1)){
                right=i;
                if(left ==-1){
                    left=i-1;
                }else{
                    break;
                }

            }
        }
        swap(root,lst.get(left),lst.get(right),0);
    }

    public void swap(TreeNode node,int left,int right,int count){
        if(count==2){
            return;
        }
        if(node !=null){
            if(node.val==left){
                node.val=right;
                count++;
            }else if(node.val==right){
                node.val=left;
                count++;
            }
            swap(node.left,left,right,count);
            swap(node.right,left,right,count);
        }
    }

    public void middleOrder(TreeNode node,List<Integer> lst){
        if(node !=null){
            middleOrder(node.left,lst);
            lst.add(node.val);
            middleOrder(node.right,lst);
        }
    }



    public static class TreeNode {
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

package leetcode.youdao;

import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */
public class YbLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root !=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int length = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i=0;i<length;i++){
                TreeNode node = queue.pollLast();
                list.add(node.val);
                if(node.left !=null){
                    queue.push(node.left);
                }
                if(node.right !=null){
                    queue.push(node.right);
                }
            }
            result.add(list);
        }
        return result;

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

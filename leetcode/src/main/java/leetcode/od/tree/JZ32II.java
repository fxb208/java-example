package leetcode.od.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class JZ32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if(root !=null){
            list.add(root);
        }
        while(list.size()>0){
            List<Integer> data = new ArrayList<>();
            int size = list.size();
            for(int i=0;i<size;i++){
                TreeNode node = list.pollLast();
                data.add(node.val);
                if(node.left != null){
                    list.add(0,node.left);
                }
                if(node.right != null){
                    list.add(0,node.right);
                }
            }
            res.add(data);
        }
        return res;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
}

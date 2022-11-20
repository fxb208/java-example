package leetcode.youdao;

import java.util.TreeSet;

public class YbGetNumber {
    public static void main(String[] args) {
        // [1,null,2,null,3,null,4,null,5]
        TreeNode root =new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.right=new TreeNode(3);
        root.right.right.right=new TreeNode(4);
        root.right.right.right.right=new TreeNode(5);
        YbGetNumber yb = new YbGetNumber();

        int[][] ops = new int[3][3];
        ops[0]=new int[]{1,2,4};
        ops[1]=new int[]{1,1,3};
        ops[2]=new int[]{0,3,5};
        System.out.println(yb.getNumber(root,ops));
    }


    public int getNumber(TreeNode root, int[][] ops) {
        TreeSet<Integer> set = new TreeSet<>();
        train(root,set);
        int result=0;
        for(int i=ops.length-1;i>=0;i--){
            int[] op = ops[i];
            while(true){
                Integer upper = set.higher(op[1]-1);
                if(upper == null || upper >op[2]){
                    break;
                }
                set.remove(upper);
                if(op[0]==1){
                    result++;
                }
            }
        }
        return result;
    }

    private void train(TreeNode node, TreeSet<Integer> set){
        if(node !=null){
            train(node.left,set);
            set.add(node.val);
            train(node.right,set);
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

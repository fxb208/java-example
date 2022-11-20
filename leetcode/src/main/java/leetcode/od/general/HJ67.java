package leetcode.od.general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * HJ67 24点游戏算法
 */
public class HJ67 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }
        double sum = 0;
        boolean[] use = new boolean[arr.length];
        LinkedList<Integer> lst = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(arr,use,sum,res,lst);
        System.out.println(res.size()>0?true:false);
    }

    public static void dfs(int[] arr,boolean[] use,double sum,List<List<Integer>> res,LinkedList<Integer> lst){
        if(res.size()>0){
            return;
        }
        if(sum==24 && lst.size()==4){
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!use[i]){
                use[i]=true;
                lst.addLast(arr[i]);
                dfs(arr,use,sum+arr[i],res,lst);
                dfs(arr,use,sum-arr[i],res,lst);
                dfs(arr,use,sum*arr[i],res,lst);
                dfs(arr,use,sum/arr[i],res,lst);
                use[i]=false;
                lst.pollLast();
            }
        }

    }
}

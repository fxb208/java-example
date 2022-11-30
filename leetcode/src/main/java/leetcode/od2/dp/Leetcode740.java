package leetcode.od2.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * 740. 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
 * 之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */
public class Leetcode740 {
    public static void main(String[] args) {
        Leetcode740 yb = new Leetcode740();
        System.out.println(yb.deleteAndEarn_list(new int[]{1,1,1,2,4,5,5,5,6}));
    }

    public int deleteAndEarn_list(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+nums[i]);
        }
        int[][] dp = new int[map.size()][2];
        //
        List<Integer> lst = new ArrayList<>(map.keySet());
        dp[0][0]=lst.get(0);
        dp[0][1]=map.get(lst.get(0));
        if(lst.size()>1){
            dp[1][0]=lst.get(1);
            if(dp[1][0]-dp[0][0]==1){
                dp[1][1]=Math.max(map.get(lst.get(1)),dp[0][1]);
            }else{
                dp[1][1]=map.get(lst.get(1))+dp[0][1];
            }
        }
        for(int i=2;i<dp.length;i++){
            int key = lst.get(i);
            dp[i][0]=key;
            if(key-dp[i-1][0]==1){
                dp[i][1]=Math.max(map.get(key)+dp[i-2][1],dp[i-1][1]);
            }else{
                dp[i][1]=map.get(key)+dp[i-1][1];
            }
            map.remove(key);
        }
        if(dp.length==1){
            return dp[0][1];
        }else{
            return Math.max(dp[dp.length-1][1],dp[dp.length-2][1]);
        }
    }

    public int deleteAndEarn_map(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+nums[i]);
        }
        int[][] dp = new int[map.size()][2];
        dp[0][0]=map.firstKey();
        dp[0][1]=map.get(map.firstKey());
        map.remove(map.firstKey());
        if(map.size()>0){
            dp[1][0]=map.firstKey();
            if(dp[1][0]-dp[0][0]==1){
                dp[1][1]=Math.max(map.get(map.firstKey()),dp[0][1]);
            }else{
                dp[1][1]=map.get(map.firstKey())+dp[0][1];
            }
            map.remove(map.firstKey());
        }
        for(int i=2;i<dp.length;i++){
            int key = map.firstKey();
            dp[i][0]=key;
            if(key-dp[i-1][0]==1){
                dp[i][1]=Math.max(map.get(key)+dp[i-2][1],dp[i-1][1]);
            }else{
                dp[i][1]=map.get(key)+dp[i-1][1];
            }
            map.remove(key);
        }
        if(dp.length==1){
            return dp[0][1];
        }else{
            return Math.max(dp[dp.length-1][1],dp[dp.length-2][1]);
        }
    }
}

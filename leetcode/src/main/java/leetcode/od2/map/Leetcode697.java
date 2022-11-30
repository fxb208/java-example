package leetcode.od2.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 697. 数组的度
 *
 * 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class Leetcode697 {

    public static void main(String[] args) {
        //
        Leetcode697 yb = new Leetcode697();
        int[] nums = new int[]{1,2,2,3,1,4,2};
        System.out.println(yb.findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {
        int res= Integer.MAX_VALUE;
        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int key = nums[i];
            if(map.containsKey(nums[i])){
                int[] value = map.get(key);
                value[0]++;
                value[2]=i;
                map.put(key,value);
            }else{
                int[] value = new int[3];
                value[0]=1;
                value[1]=i;
                value[2]=i;
                map.put(key,value);
            }
        }
        int count = 0;
        for(Integer key:map.keySet()){
            if(map.get(key)[0]>count){
                count = map.get(key)[0];
                res = map.get(key)[2]-map.get(key)[1]+1;
            }else if(map.get(key)[0]==count){
                res = Math.min(res,map.get(key)[2]-map.get(key)[1]+1);
            }
        }
        return res;
    }


    public int findShortestSubArray_low(int[] nums) {
        int res= Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> lst = new ArrayList<>();
        int count = 0;
        for(Integer key:map.keySet()){
            if(map.get(key)>count){
                count = map.get(key);
                lst.clear();
                lst.add(key);
            }else if(map.get(key).equals(count)){
                lst.add(key);
            }
        }
        for(int i=0;i<lst.size();i++){
            int begin = -1;
            int end = -1;
            for(int j=0;j<nums.length;j++){
                if(lst.get(i).equals(nums[j])){
                    if(end==-1){
                        begin = j;
                    }
                    end = j+1;
                }
            }
            res=Math.min(end-begin,res);
        }

        return res;
    }
}

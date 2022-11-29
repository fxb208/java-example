package leetcode.od2.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode454
 *
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class leetcode454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int key = nums1[i]+nums2[j];
                map.put(key,map.getOrDefault(key,0)+1);
            }
        }
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                int key = 0 - nums1[i] - nums2[j];
                if(map.containsKey(key)){
                    res+=map.get(key);
                }
            }
        }
        return res;
    }

    public int fourSumCount_force(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int[] res = new int[1];
        List<Integer> path = new ArrayList<>();
        List<int[]> lst = new ArrayList<>();
        lst.add(nums1);
        lst.add(nums2);
        lst.add(nums3);
        lst.add(nums4);
        backTrack(res,path,0,lst,0);
        return res[0];
    }

    public void backTrack(int[] res,List<Integer> path,int target,List<int[]> lst,int idx){
        if(path.size()==4){
            if(target==0){
                res[0]++;
            }
            return;
        }
        for(int i=idx;i<4;i++){
            for(int j=0;j<lst.get(i).length;j++){
                int num = lst.get(i)[j];
                if(path.size()==3 && num>0 && target<0){
                    continue;
                }
                path.add(num);
                backTrack(res,path,target-num,lst,i+1);
                path.remove(path.size()-1);
            }
        }
    }

}

package leetcode.youdao;

import java.util.HashMap;
import java.util.Map;

/**
 * 260. 只出现一次的数字 III
 * https://leetcode.cn/problems/single-number-iii/
 */
public class YbSingleNumber_3 {
    public int[] singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] result = new int[2];
        int index =0;
        for(int num : map.keySet()){
            if(map.get(num)==1){
                result[index]=num;
                index++;
            }
        }
        return result;
    }
}

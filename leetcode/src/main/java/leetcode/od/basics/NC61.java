package leetcode.od.basics;

import java.util.HashMap;
import java.util.Map;

/**
 * NC61 两数之和
 * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
 */
public class NC61 {
    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                result[1]=i+1;
                result[0]=map.get(target-numbers[i])+1;
                break;
            }else{
                map.put(numbers[i],i);
            }
        }
        return result;
    }
}

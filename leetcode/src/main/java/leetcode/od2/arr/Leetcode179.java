package leetcode.od2.arr;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 179. 最大数
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class Leetcode179 {
    public static void main(String[] args) {
        Leetcode179 yb = new Leetcode179();
        //
        //int[] nums = new int[]{3,30,34,5,9};
        int[] nums = new int[]{34323,3432};
        System.out.println(yb.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        StringBuffer res = new StringBuffer();
        String[] arr = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(arr,(o1, o2) -> {
            String str2 = o2+o1;
            String str1 = o1+o2;
            if(Long.valueOf(str2)>Long.valueOf(str1)){
                return 1;
            }else if(Long.valueOf(str2)<Long.valueOf(str1)){
                return -1;
            }else{
                return 0;
            }
        });
        if(arr[0].startsWith("0")){
            return "0";
        }
        for(String key : arr){
            res.append(key);
        }
        return res.toString();
    }


    /**
     *
     * @param nums
     * @return
     */
    public String largestNumber_bug(int[] nums) {
        StringBuffer res = new StringBuffer();
        TreeMap<String,Integer> map = new TreeMap<String ,Integer>((o1, o2) -> {
            String str2 = o2+o1;
            String str1 = o1+o2;
            if(Long.valueOf(str2)>Long.valueOf(str1)){
                return 1;
            }else if(Long.valueOf(str2)<Long.valueOf(str1)){
                return -1;
            }else{
                // return 0   33 3 bug
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<nums.length;i++){
            String key = String.valueOf(nums[i]);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        if(map.firstKey().startsWith("0")){
            return "0";
        }
        for(String key : map.keySet()){
            int num = map.get(key);
            while(num>0){
                res.append(key);
                num--;
            }
        }
        return res.toString();
    }

//    public String largestNumber(int[] nums) {
//        StringBuffer res = new StringBuffer();
//        TreeMap<String,Integer> map = new TreeMap<String ,Integer>((o1, o2) -> {
//                int len = Math.min(o1.length(),o2.length());
//                int max = Math.max(o1.length(),o2.length());
//                for(int i=0;i<len;i++){
//                    if(o2.charAt(i)==o1.charAt(i)){
//                        continue;
//                    }else{
//                        return o2.charAt(i)-o1.charAt(i);
//                    }
//                }
//                for(int i=len;i<max;i++){
//                    if(o1.length()==len){
//                        if(o2.charAt(i)==o1.charAt(len-1)){
//                            continue;
//                        }else{
//                            return o2.charAt(i)-o1.charAt(len-1);
//                        }
//                    }else if(o2.length()==len){
//                        if(o1.charAt(i)==o2.charAt(len-1)){
//                            continue;
//                        }else{
//                            return o2.charAt(len-1)-o1.charAt(i);
//                        }
//                    }
//                }
//                return 0;
//        });
//        for(int i=0;i<nums.length;i++){
//            String key = String.valueOf(nums[i]);
//            map.put(key,map.getOrDefault(key,0)+1);
//        }
//        for(String key : map.keySet()){
//            int num = map.get(key);
//            while(num>0){
//                res.append(key);
//                num--;
//            }
//        }
//        return res.toString();
//    }
}

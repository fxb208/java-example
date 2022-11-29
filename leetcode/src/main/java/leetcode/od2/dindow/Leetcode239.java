package leetcode.od2.dindow;

import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 */
public class Leetcode239 {
    public static void main(String[] args) {
        //
        Leetcode239 yb = new Leetcode239();
        int[] nums = new int[]{1,3,1,2,0,5};
        int k =3;
        int[] res = yb.maxSlidingWindow(nums,k);
        System.out.println(res);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int left = 0;
        int right = k-1 ;

        LinkedList<Integer> window = new LinkedList<>();
        for(int i = 0;i< k;i++){
            while(window.peekLast() !=null && nums[window.peekLast()]<nums[i]){
                window.pollLast();
            }
            window.add(i);
        }
        res[0]=nums[window.peekFirst()];
        while(right<nums.length-1){
            left++;
            right++;
            while(window.peekLast() !=null && nums[window.peekLast()]<nums[right]){
                window.pollLast();
            }
            window.add(right);
            while(window.peekFirst()<left){
                window.pollFirst();
            }
            res[left]=nums[window.peekFirst()];
        }
        return res;
    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] res = new int[nums.length-k+1];
//        int left = 0;
//        int right = k-1 ;
//
//        LinkedList<Integer> window = new LinkedList<>();
//        for(int i = 0;i< k;i++){
//            window.add(nums[i]);
//        }
//        res[0]=max(window);
//
//        while(right<nums.length-1){
//            left++;
//            right++;
//            window.add(nums[right]);
//            window.pollFirst();
//            res[left]=max(window);
//        }
//        return res;
//    }
//
//    public int max(List<Integer> window){
//        int max = window.get(0);
//        for(int i = 0;i< window.size();i++){
//            if(window.get(i)>max){
//                max = window.get(i);
//            }
//        }
//        return max;
//    }

}

package leetcode.od3.arr;

import java.util.TreeSet;

/**
 * 41. 缺失的第一个正数
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class Leetcode41 {
    public static void main(String[] args) {
        Leetcode41 yb = new Leetcode41();
        System.out.println(yb.firstMissingPositive(new int[]{3,4,-1,1}));
    }

    public int firstMissingPositive_low(int[] nums) {
        int len = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=len && nums[i]>0){
                set.add(nums[i]);
            }
        }
        for(int i=1;i<=nums.length;i++){
            if(set.isEmpty()){
                return i;
            }
            int num = set.pollFirst();
            if(num>i){
                return i;
            }
        }
        return len+1;
    }

    /**
     * https://leetcode.cn/problems/first-missing-positive/solutions/7703/tong-pai-xu-python-dai-ma-by-liweiwei1419/
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * https://leetcode.cn/problems/first-missing-positive/solutions/304743/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
     * @param nums
     * @return
     */
    public int firstMissingPositive_(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}

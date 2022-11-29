package leetcode.od2.arr;

/**
 * 31. 下一个排列
 *
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
 * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列
 * 就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 */
public class Leetcode31 {
    public void nextPermutation(int[] nums) {
        int right = nums.length-1;
        int left = nums.length-2;
        while(left>=0){
            if(nums[left]<nums[right]){
                break;
            }
            left--;
            right--;
        }
        if(left<0){
            int i= 0;
            int j=nums.length-1;
            while(i<j){
                swap(nums,i,j);
                i++;
                j--;
            }
            return;
        }
        for(int i=nums.length-1;i>left;i--){
            if(nums[i]>nums[left]){
                swap(nums,i,left);
                break;
            }
        }
        int i= right;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}

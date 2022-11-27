package leetcode.od2.list;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Leetcode283 {
    public static void main(String[] args) {
        Leetcode283 yb = new Leetcode283();
        yb.moveZeroes(new int[]{73348,66106,-85359,53996,18849,-6590,-53381,-86613,-41065,83457,0});
    }

    public void moveZeroes(int[] nums) {
        int idx=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                idx++;
                nums[idx]=nums[i];
            }
        }
        for(int i=idx+1;i<nums.length;i++){
            nums[i]=0;
        }
    }
}

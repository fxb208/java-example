package leetcode.od3.arr;

/**
 * 75. 颜色分类
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Leetcode75 {
    public static void main(String[] args) {
        Leetcode75 yb = new Leetcode75();
        int[] nums = new int[]{2,0,2,1,1,0};
        yb.sortColors(nums);
        System.out.println(nums);
    }

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        for(int i=0;i<nums.length;i++){
            while((nums[i]==2 && right>i) || (nums[i]==0 && i>left)){
                if(nums[i]==0 && i>left){
                    int temp = nums[left];
                    nums[left]=nums[i];
                    nums[i]=temp;
                    left++;
                }
                if(nums[i]==2 && right>i){
                    int temp = nums[right];
                    nums[right]=nums[i];
                    nums[i]=temp;
                    right--;
                }
            }
        }
    }
}

package leetcode.od.dp;

/**
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置
 */
public class Leetcode45 {
    public static void main(String[] args) {
        Leetcode45 yb = new Leetcode45();
         int[] nums = new int[]{6,2,6,1,7,9,3,5,3,7,2,8,9,4,7,7,2,2,8,4,6,6,1,3};
        //int[] nums = new int[]{1,1,1,1};
        //int[] nums = new int[]{1,2,3};
        System.out.println(yb.jump(nums));
    }

    /**
     * https://leetcode.cn/problems/jump-game-ii/solutions/1973098/by-bestqiang-ka49/
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        // 我们用 i 和 end 标记了可以选择的跳跃步数，farthest 标记了所有选择 [i..end] 中能够跳到的最远距离，jumps 记录跳跃次数
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

//    public int jump(int[] nums) {
//        int res = 0;
//        if(nums.length==1){
//            return res;
//        }
//        int right=nums[0];
//        if(right>=nums.length-1){
//            res++;
//            return res;
//        }
//        for(int i=0;i<nums.length;){
//            int index = i;
//            int maxIndex= i;
//            for(int j=1;j<=right;j++){
//                if(i+j>=nums.length-1){
//                    index = nums.length-1;
//                    break;
//                }else if(i+j+nums[i+j]>maxIndex){
//                    maxIndex = i+j+nums[i+j];
//                    index=i+j;
//                }
//            }
//            res++;
//            if(index+nums[index]>= nums.length-1){
//                res++;
//                return res;
//            }
//            i=index;
//            right=nums[i];
//        }
//        return res;
//    }
}

package leetcode.od2.greedy;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。 返回容器可以储存的最大水量。
 */
public class Leetcode11 {

    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            int temp = Math.min(height[left],height[right])*(right-left);
            res = Math.max(temp,res);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}

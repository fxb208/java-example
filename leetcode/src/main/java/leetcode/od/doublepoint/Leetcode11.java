package leetcode.od.doublepoint;

/**
 * 11. 盛最多水的容器
 */
public class Leetcode11 {
    public static void main(String[] args) {
        Leetcode11 yb = new Leetcode11();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(yb.maxArea(height));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while(left<right){
            res = Math.max(res,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}

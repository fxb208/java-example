package com.yb.project.algorithm.one.doublepointer;

import java.util.Arrays;

/**
 * leetcode 611. 有效三角形的个数
 * @author fxb20
 * 给定一个包含非负整数的数组nums ，返回其中可以组成三角形三条边的三元组个数。
 * 
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是: 
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbTriangleNumber {
	public static void main(String[] args) {
		int[] nums=new int[] {4,2,3,4};
		YbTriangleNumber yb=new YbTriangleNumber();
		System.out.println(yb.triangleNumber(nums));
	}
	
    public int triangleNumber(int[] nums) {
        int n = nums.length;
       Arrays.sort(nums);
       int ans = 0;
       for (int i = 0; i < n; ++i) {
           int k = i;
           for (int j = i + 1; j < n; ++j) {
               while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                   ++k;
               }
               ans += Math.max(k - j, 0);
           }
       }
       return ans;
   }

    public int triangleNumber1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
            	int k=j;
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    ++k;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }

	
    public int triangleNumber0(int[] nums) {
    	int res=0;
    	int n=nums.length;
    	Arrays.sort(nums);
    	for(int i=0;i<n;i++) {
    		for(int j=i+1;j<n;j++) {
        		int k=n-1;
    			while(k>j && nums[k]>=nums[i]+nums[j]) {
    				k--;
    			}
    			res+=Math.max(k-j, 0);
    		}
    	}
    	return res;
    }
}

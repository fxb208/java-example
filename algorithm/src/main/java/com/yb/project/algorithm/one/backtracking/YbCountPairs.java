package com.yb.project.algorithm.one.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 2183. 统计可以被 K 整除的下标对数目
 * @author fxb20
 *	给你一个下标从 0 开始、长度为 n 的整数数组 nums 和一个整数 k ，返回满足下述条件的下标对 (i, j) 的数目：
 * 0 <= i < j <= n - 1 且 nums[i] * nums[j] 能被 k 整除。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3,4,5], k = 2
 * 输出：7
 * 解释：
 * 
 * 共有 7 对下标的对应积可以被 2 整除：
 * (0, 1)、(0, 3)、(1, 2)、(1, 3)、(1, 4)、(2, 3) 和 (3, 4)
 * 它们的积分别是 2、4、6、8、10、12 和 20 。
 * 其他下标对，例如 (0, 2) 和 (2, 4) 的乘积分别是 3 和 15 ，都无法被 2 整除。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-array-pairs-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbCountPairs {
	
	public static void main(String[] args) {
		YbCountPairs yb=new YbCountPairs();
		//int[] nums=new int[] {1,2,3};
		//int[] nums=new int[] {3,2,6,1,8,4,1};
		int[] nums=new int[] {1,2,3,4,5};
		System.out.println(yb.countPairs(nums, 2));
	}
	
	/**
	 * 设m=gcd(a,k),n=gcd(b,k)
	 * if(m * n % k == 0)       
	 * 		a*b %k= (m*x * n*y) %k=(mn%k) *(xy)=0
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
    public long countPairs(int[] nums, int k) {
    	long result=0;
    	Map<Long, Long> map=new HashMap<Long, Long>();
    	for(int i=0;i<nums.length;i++) {
    		long gcd=gcd(nums[i],k);
    		if(map.containsKey(gcd)) {
    			map.put((long)gcd, (long)map.get(gcd)+1);
    		}else {
    			map.put((long)gcd, (long)1);
    		}
    	}
    	Set<Long> set=map.keySet();
    	List<Long> list=new ArrayList<Long>(set);
    	for(int i=0;i<list.size();i++) {
    		for(int j=i;j<list.size();j++) {
    			if(i==j) {
    				long l=list.get(i);
    				if(l*l %k==0) {
    					result+=map.get(l)*(map.get(l)-1)/2;
    				}
    			}else {
    				if((long)list.get(i)*(long)list.get(j) %k==0) {
        				result+=map.get(list.get(i))*map.get(list.get(j));
        			}	
    			}
    			
    			
    			
    		}
    	}
    	return result;
    }
    
    int gcd(int a,int b) {
    	return b==0 ? a:gcd(b,a%b);
    }
	
	
	long res;
	
    public long countPairs0(int[] nums, int k) {
    	ArrayList<Integer> path=new ArrayList<Integer>();
    	boolean[] used=new boolean[nums.length];
    	backtracking(path,0,used,nums,k);
    	return res;
    }
    
    public void backtracking(List<Integer> path,int idx,boolean[] used,int[] nums,int k) {
    	if(path.size()==2) {
    		int result=path.get(0)*path.get(1);
    		if(result % k==0) {
    			res++;
    		}
    		return;
    	}
    	if(idx==nums.length) {
    		return;
    	}
    	if(used[idx]) {
    		return;
    	}
    	for(int i=idx;i<nums.length;i++) {
    		path.add(nums[i]);
    		backtracking(path,i+1,used,nums,k);
    		path.remove(path.size()-1);
    	}
    	used[idx]=true;
    }
}

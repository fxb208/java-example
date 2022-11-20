package com.yb.project.algorithm.one.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 * @author fxb20
 * 给定一个数字字符串 num，比如 "123456579"，我们可以将它分成「斐波那契式」的序列 [123, 456, 579]。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * 返回从 num 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * 
 * 输入：num = "1101111"
 * 输出：[11,0,11,11]
 * 解释：输出[110,1,111]也可以。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/split-array-into-fibonacci-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbSplitIntoFibonacci {
	
	public static void main(String[] args) {
		YbSplitIntoFibonacci yb=new YbSplitIntoFibonacci();
		yb.splitIntoFibonacci("0123");
	}
	
    public List<Integer> splitIntoFibonacci(String num) {
    	List<Integer> res=new LinkedList<Integer>();
    	backtrack(res,num,0,0,0);
    	return res;
    }
    
    public boolean backtrack(List<Integer> res,String num,int idx,int sum,int pre) {
    	if(idx==num.length()) {
    		return res.size()>=3;
    	}
    	long currLong = 0;
    	for(int i=idx;i<num.length();i++) {
    		if(i>idx && num.charAt(idx)=='0') {
    			break;
    		}
    		currLong = currLong * 10 + num.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            int cur = (int) currLong;
    		if(res.size()>=2) {
    			if(cur>sum) {
        			break;
        		}else if(cur<sum) {
        			continue;
        		}
    		}
    		res.add(cur);
			if(backtrack(res,num,i+1,cur+pre,cur)) {
				return true;
			}else {
				res.remove(res.size()-1);
			}
    	}
    	return false;
    }
    
    /**
     * 动态规划
     * @param n
     * @return
     * leecode 509. 斐波那契数
     */
    public int fib(int n) {
    	if(n<0 || n==0) {
    		return 0;
    	}
    	int[] dp=new int[n+1];
    	dp[0]=0;
    	dp[1]=1;
    	for(int i=2;i<dp.length;i++) {
    		dp[i]=dp[i-1]+dp[i-2];
    	}
    	return dp[n];
    }
    
}

package com.yb.project.algorithm.one.dynamicprogramming.day07;

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fxb20
 *
 */
public class YbMaxProfit {
	public static void main(String[] args) {
		int[] prices=new int[] {3,2,6,5,0,3};
		YbMaxProfit yb=new YbMaxProfit();
		System.out.println(yb.maxProfit3(prices));
	}
	
	/**
	 * leecode 121. 买卖股票的最佳时机
	 * @author fxb20
	 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
	 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
	 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
	 * 
	 * 输入：[7,1,5,3,6,4]
	 * 输出：5
	 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
	 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

	 */
    public int maxProfit(int[] prices) {
    	int result=0;
    	int min=prices[0];
    	for(int i=1;i<prices.length;i++) {
    		result=Math.max(result, prices[i]-min);
    		min=Math.min(min, prices[i]);
    		
    	}
    	return result;
    }
	
    /**
     * leecode 121
     * prices[i]-prices[j] && i>=j 价值最大
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
    	int[] dp=new int[prices.length];  //[0,n] 中prices[i]最小
    	dp[0]=prices[0];
    	int result=0;
    	for(int i=1;i<prices.length;i++) {
    		dp[i]=Math.min(dp[i-1], prices[i]);
    		result=Math.max(result, prices[i]-dp[i-1]);
    	}
    	return result;
    }
	
    /**
     * leecode 122. 买卖股票的最佳时机 II
     * @param prices
     * @return
     * 
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。
     * 你也可以先购买，然后在 同一天 出售。返回 你能获得的 最大 利润 。
     * 
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 
     * 这笔交易所能获得利润 = 5 - 1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 
     * 这笔交易所能获得利润 = 6 - 3 = 3 。
     * 总利润为 4 + 3 = 7 。
     */
    public int maxProfit3(int[] prices) {
    	int max=prices[0];
    	int min=prices[0];
    	int result=0;
    	for(int i=1;i<prices.length;i++) {
    		if(prices[i]>=max) {
    			max=prices[i];  //创新高
    		}else if(min<prices[i] && prices[i]<max) {
    			result=result+max-min;  //股票下跌，赶紧出货
    			min=prices[i]; //观望
    			max=prices[i]; 
    		}else {
    			if(max>min) {
    				result=result+max-min;  //创新低，赶紧出货	
    			}
    			max=prices[i]; //观望
    			min=prices[i];
    		}
			if(i==prices.length-1 && max>min) {
				result=result+max-min;
			}
    	}
    	return result;
    }

}

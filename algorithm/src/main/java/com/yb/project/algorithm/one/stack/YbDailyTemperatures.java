package com.yb.project.algorithm.one.stack;

import java.util.ArrayDeque;

/**
 * leetcode 739. 每日温度
 * @author fxb20
 *	给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，
 *	其中answer[i]是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/daily-temperatures
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbDailyTemperatures {
	
	public static void main(String[] args) {
		int[] temperatures=new int[] {30,60,90};
		YbDailyTemperatures yb=new YbDailyTemperatures();
		System.out.println(yb.dailyTemperatures(temperatures));
	}
	
    public int[] dailyTemperatures(int[] temperatures) {
    	int[] result=new int[temperatures.length];
    	ArrayDeque<int[]> deque=new ArrayDeque<int[]>();
    	for(int i=0;i<temperatures.length;i++) {
			int [] peek=deque.peek();
			while(peek !=null && peek[0]<temperatures[i]) {
				int[] poll=deque.poll();
				result[poll[1]]=i-poll[1];
				peek=deque.peek();
			}
			deque.push(new int[]{temperatures[i],i});
    	}	
    	return result;
    }
}

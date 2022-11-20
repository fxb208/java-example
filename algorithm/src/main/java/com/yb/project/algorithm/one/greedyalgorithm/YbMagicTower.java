package com.yb.project.algorithm.one.greedyalgorithm;

import java.util.PriorityQueue;

/**
 * LCP 30. 魔塔游戏
 * @author fxb20
 * 小扣当前位于魔塔游戏第一层，共有 N 个房间，编号为 0 ~ N-1。
 * 每个房间的补血道具/怪物对于血量影响记于数组 nums，其中正数表示道具补血数值，即血量增加对应数值；
 * 负数表示怪物造成伤害值，即血量减少对应数值；0 表示房间对血量无影响。
 * 小扣初始血量为 1，且无上限。
 * 假定小扣原计划按房间编号升序访问所有房间补血/打怪，为保证血量始终为正值，
 * 小扣需对房间访问顺序进行调整，每次仅能将一个怪物房间（负数的房间）调整至访问顺序末尾。
 * 请返回小扣最少需要调整几次，才能顺利访问所有房间。若调整顺序也无法访问完全部房间，请返回 -1。示例 1：
 * 
 * 输入：nums = [100,100,100,-250,-60,-140,-50,-50,100,150]
 * 输出：1
 * 解释：初始血量为 1。至少需要将 nums[3] 调整至访问顺序末尾以满足要求。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/p0NxJO
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbMagicTower {
	
	public static void main(String[] args) {
		YbMagicTower yb=new YbMagicTower();
		//int[] nums=new int[] {100,100,100,-250,-60,-140,-50,-50,100,150};
		int[] nums=new int[] {-100,-100,100,-250,-60,-140,150,150,100,150};
		System.out.println(yb.magicTower(nums));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(12);
		pq.offer(11);
		pq.offer(15);
		pq.add(4);
		pq.add(5);
		pq.add(6);
		pq.add(7);
		System.out.println(pq);
		pq.remove(5);
		System.out.println(pq);
	}
	
    public int magicTower(int[] nums) {
    	PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
    	int result=0;
    	long sum=0;
    	long path=0;
    	int num=0;
    	for(int i=0;i<nums.length;i++) {
    		num=nums[i];
    		sum+=num;
    		path+=num;
    		if(num<0) {
    			queue.add(num); //加入队列
    		}
    		if(path<0) {
    			int iMax=queue.poll();
    			path-=iMax; //移动最大的到末尾	
    			result++;
    		}
    	}
    	if(sum<0) {
    		return -1;
    	}
    	return result;
    }
}

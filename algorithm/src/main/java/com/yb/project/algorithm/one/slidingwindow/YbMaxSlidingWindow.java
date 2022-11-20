package com.yb.project.algorithm.one.slidingwindow;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 
 * @author fxb20
 *
 */
public class YbMaxSlidingWindow {
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,3,-1,-3,5,3,6,7};
		YbMaxSlidingWindow yb=new YbMaxSlidingWindow();
		int[] result=yb.maxSlidingWindow(nums,3);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
	
	/**
	 * 双端队列版本
	 * @param nums
	 * @param k
	 * @return
	 */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<k;i++) {
        	while(!list.isEmpty() && nums[i]>= nums[list.peekLast()]) {
        		list.pollLast();
        	}
        	list.offerLast(i);
        }
        ans[0]=nums[list.peekFirst()];
        for(int i=k;i<n;i++) {
        	while(!list.isEmpty() && nums[i]>= nums[list.peekLast()]) {
        		list.pollLast();
        	}
        	list.offerLast(i);
        	if(list.peekFirst()<=i-k) {
        		list.pollFirst();
        	}
        	ans[i-k+1]=nums[list.peekFirst()];
        }
        return ans;

    }
	
	/**
	 * 最大堆可以实现，那么红黑树应该也可以
	 *  红黑树
	 * @param nums
	 * @param k
	 * @return
	 */
    public int[] maxSlidingWindow3(int[] nums, int k) {
    	int n = nums.length;
    	int[] ans = new int[n - k + 1];
    	TreeMap<Integer, Integer> map=new TreeMap<Integer, Integer>(new Comparator<Integer>() {
    		 public int compare(Integer pair1, Integer pair2) {
                 return pair2 - pair1;
             }

		});
       	for(int i=0;i<k;i++) {
       		map.put(nums[i],i);
    	}
    	ans[0]=map.firstKey();
    	for(int i=k;i<n;i++) {
    		map.put(nums[i],i);
			while(map.get(map.firstKey())<=i-k) {
				map.remove(map.firstKey());
			}
			ans[i-k+1]=map.firstKey();
    	}
        return ans;
    }
	
	/**
	 *  最大堆
	 * @param nums
	 * @param k
	 * @return
	 */
    public int[] maxSlidingWindow2(int[] nums, int k) {
    	int n = nums.length;
    	int[] ans = new int[n - k + 1];
    	
    	PriorityQueue<int[]> queue=new PriorityQueue<int[]>(new Comparator<int[]>() {
    		 public int compare(int[] pair1, int[] pair2) {
                 return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
             }

		});
    	for(int i=0;i<k;i++) {
    		queue.offer(new int[] {nums[i],i});
    	}
    	ans[0]=queue.peek()[0];
    	for(int i=k;i<n;i++) {
    		queue.offer(new int[] {nums[i],i});
			while(queue.peek()[1]<=i-k) {
				queue.poll();
			}
			ans[i-k+1]=queue.peek()[0];
    	}
        return ans;
    }
	
	/**
	 * 时间夫扎渡 O(nk)  n为数组长度，k为窗口长度
	 * @param nums
	 * @param k
	 * @return
	 */
    public int[] maxSlidingWindow1(int[] nums, int k) {
    	int n = nums.length;
    	int[] ans = new int[n - k + 1];
    	LinkedList<Integer> list=new LinkedList<Integer>();
    	for(int i=0;i<n;i++) {
    		list.add(nums[i]);
    		if(list.size()==k) {
    			int max=Integer.MIN_VALUE;
    			for(Integer e:list) {
    				max=Math.max(max, e);
    			}
    			ans[i-k+1]=max;
    			list.removeFirst();
    		}
    	}
        return ans;
    }
	
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        Deque<Integer> deque = new LinkedList<Integer>();
//        for (int i = 0; i < k; ++i) {
//            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
//                deque.pollLast();
//            }
//            deque.offerLast(i);
//        }
//
//        int[] ans = new int[n - k + 1];
//        ans[0] = nums[deque.peekFirst()];
//        for (int i = k; i < n; ++i) {
//            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
//                deque.pollLast();
//            }
//            deque.offerLast(i);
//            while (deque.peekFirst() <= i - k) {
//                deque.pollFirst();
//            }
//            ans[i - k + 1] = nums[deque.peekFirst()];
//        }
//        return ans;
//    }
}

package com.yb.project.algorithm.one.nowcoder.exam1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Exam3 {

	
	public static void main(String[] args) {
		LinkedBlockingQueue<Integer> queue=new LinkedBlockingQueue<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(12);
		pq.peek();
		pq.poll();
		
		queue.offer(12);
		
		Deque<Integer> deque = new LinkedList<Integer>();
	}
}

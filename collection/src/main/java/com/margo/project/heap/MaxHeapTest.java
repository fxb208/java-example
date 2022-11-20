package com.margo.project.heap;

public class MaxHeapTest {
	public static void main(String[] args) {
		Integer[] arr=new Integer[]{10,12,4,20,11,58,9,4,13,14};
		MaxHeap heap=new MaxHeap(arr);
		//heap.maxHeapify(0);
		heap.buildMaxHeap();
		heap.heapSort(); 
		System.out.println(heap.toString());
	}
}

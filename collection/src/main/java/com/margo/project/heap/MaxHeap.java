package com.margo.project.heap;

import java.util.Arrays;

/**
 * 最大堆
 * @author fxb20
 *
 */
public class MaxHeap {
	int length; //堆的长度
	Integer[] arr=null;
	public MaxHeap(Integer[] arr) {
		super();
		this.length = arr.length;
		this.arr=arr;
	}
	/**
	 * 父节点
	 * @param i
	 * @return
	 */
	public int parent(int i) {
		return arr[i/2];
	}
	/**
	 * 左子节点
	 * @param i
	 * @return
	 */
	public int left(int i) {
		return 2*i+1;
	}
	/**
	 * 右子节点
	 * @param i
	 * @return
	 */
	public int right(int i) {
		return 2*i+2;
	}
	
	public void buildMaxHeap() {
		for(int i=(arr.length/2-1); i>=0; i--) {
			maxHeapify(i);
		}
	}
	
	public void heapSort() {
		for(int i=arr.length-1;i>=1;i--) {
			exchange(i,0);
			length=length-1;
			maxHeapify(0);
		}
	}
	
	/**
	 * 最大堆
	 * @param i
	 */
	public void maxHeapify(int i){
		int largset;
		int l=left(i);
		int r=right(i);
		if(l<length && arr[l]>=arr[i]) {
			largset=l;
		}else {
			largset=i;
		}
		if(r <length && arr[r]>=arr[largset]) {
			largset=r;
		}
		if(largset !=i) {
			exchange(largset,i);
			maxHeapify(largset);
		}
	}
	
	/**
	 * 交换
	 * @param largset
	 * @param i
	 */
	public void exchange(int largset,int i) {
		int data=arr[largset];
		arr[largset]=arr[i];
		arr[i]=data;
	}
	@Override
	public String toString() {
		return "MaxHeap [length=" + length + ", arr=" + Arrays.toString(arr) + "]";
	}
	
}

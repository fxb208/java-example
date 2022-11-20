package com.yb.project.algorithm.one.divideandconquer;

/**
 * 归并排序
 * @author fxb20
 *
 */
public class YbMergeSort {
	
	public static void main(String[] args) {
		YbMergeSort mergeSort=new YbMergeSort();
		int[] arr=new int[] {2,4,5,7,1,2,3,6,0};
		mergeSort.mergeSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
	}

	public void mergeSort(int[] arr,int begin,int end) {
		if(begin<end) {
			int middle=(begin+end)/2;
			mergeSort(arr,begin,middle);
			mergeSort(arr,middle+1,end);
			merge(arr,begin,middle,end);
		}
		
	}
	
	public void merge(int[] arr,int begin,int middle,int end) {
		int[] leftArr=new int[middle-begin+1];
		int[] rightArr=new int[end-middle];
		for(int i=0;i<leftArr.length;i++) {
			leftArr[i]=arr[begin+i];
		}
		for(int i=0;i<rightArr.length;i++) {
			rightArr[i]=arr[middle+1+i];
		}
		int cur=begin;
		int x=0;
		int y=0;
		while(x<leftArr.length || y<rightArr.length) {
			if(x==leftArr.length) {
				arr[cur]=rightArr[y];
				y++;
			}else if(y==rightArr.length) {
				arr[cur]=leftArr[x];
				x++;
			}else if(leftArr[x]<rightArr[y]) {
				arr[cur]=leftArr[x];
				x++;
			}else {
				arr[cur]=rightArr[y];
				y++;
			}
			cur++;
		}
	}
	
//	public void merge(int[] arr,int begin,int middle,int end) {
//		int[] leftArr=new int[middle-begin+1];
//		int[] rightArr=new int[end-middle];
//		for(int i=0;i<leftArr.length;i++) {
//			leftArr[i]=arr[begin+i];
//		}
//		for(int i=0;i<rightArr.length;i++) {
//			rightArr[i]=arr[middle+1+i];
//		}
//
//		int x=0;
//		int y=0;
//		
//		for(int i=0;i<end-begin+1;i++) {
//			if(x<leftArr.length && y<rightArr.length) {
//				if(leftArr[x]>rightArr[y]) {
//					arr[begin+i]=rightArr[y];
//					y++;
//				}else {
//					arr[begin+i]=leftArr[x];
//					x++;
//				}	
//			}else if(x<leftArr.length && y==rightArr.length) {
//				arr[begin+i]=leftArr[x];
//				x++;
//			}else if(x==leftArr.length && y<rightArr.length) {
//				arr[begin+i]=rightArr[y];
//				y++;
//				
//			}
//			
//		}
//	}
}

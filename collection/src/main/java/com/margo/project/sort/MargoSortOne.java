package com.margo.project.sort;

/**
 * 快速排序
 * 	{5, 8, 9, 3, 2, 10, 13, 1}
 * @author fxb208
 *
 */
public class MargoSortOne {
	
	public static void sort(int[] a) {
		sort(a,0,a.length);
	}
	
	private static void sort(int[] a,int p,int q) {
		if(q-p<2) {
			return;
		}
		int m=partition(a,p,q);
		arrPrint(a);
		sort(a,0,m);
		sort(a,m+1,q);
		
	}
	
	/**
	 * 找到基准
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] a,int p,int q) {
		int pivot=a[p];
		int i=p;
		int j=q;
		while(i<j) {
			 // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
	         while(i < j && a[--j]>=pivot);
	         if(i<j) {
	        	 a[i]=a[j];
	         }
	 
	         // 再从左往右边找，直到找到比base值大的数
	         while(i < j && a[++i]<=pivot);
	         if(i<j) {
	        	 a[j]=a[i];
	         }
		}
		 // 将基准数放到中间的位置（基准数归位）
		a[j]=pivot;
		return j;
	}
	
	public static void arrPrint(int[] arrInt) {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i=0;i<arrInt.length;i++) {
			sb.append(arrInt[i]);
			if(i<arrInt.length-1) {
				sb.append(",");
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
}

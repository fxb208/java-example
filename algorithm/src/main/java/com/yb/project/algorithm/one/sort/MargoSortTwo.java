package com.yb.project.algorithm.one.sort;

public class MargoSortTwo {
	public static void sort(int[] a) {
		sort(a,0,a.length-1);
	}
	
	private static void sort(int[] a,int first,int last) {
		if(a.length==1) {
			return;
		}
		quictSort(a,first,last);
		arrPrint(a);
	}
	
	
	private static void quictSort(int[] a, int first, int last) {
		   if(first > last) {
		        return;
		    }
		int m=a[first];
		int i=first;
		int j=last;
		while(i!=j) {
			while(i<j && a[j]>=m) {
				j--;
			}
			while(i<j && a[i]<=m) {
				i++;
			}
			if(i<j) {
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				//arrPrint(a);
			}
		}
		a[first]=a[i];
		a[i]=m;
		quictSort(a,0,i-1);
		quictSort(a,i+1,last);
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

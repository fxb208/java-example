package com.margo.project.sort;

/**
 * 简单选择排序
 * @author fxb208
 *
 */
public class MargoSortFour {
	public static void simpleSelectSort(int[] arrInt) {
		for(int i=0;i<arrInt.length-1;i++) {
			int k=i;//k为最小值下标
			for(int j=i+1;j<arrInt.length;j++) {
				if(arrInt[j]<arrInt[k]) {
					k=j;
				}
			}
			if(k!=i) {//如果最小下标不是i，则最小值arr[k]与arr[i]互换位置
				int temp=arrInt[i];
				arrInt[i]=arrInt[k];
				arrInt[k]=temp;
			}
		}
	}
}

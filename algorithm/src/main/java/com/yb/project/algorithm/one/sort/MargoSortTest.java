package com.yb.project.algorithm.one.sort;


public class MargoSortTest {
	
	int[] arrInteger=new int[] {5, 8, 9, 3, 2, 10, 13, 6};
	
	//@Test
	public void sortOneTest() {
		//MargoSortTwo.sort(arrInteger);
		MargoSortTwo.sort(arrInteger);
	}
	
	//@Test
	public void sortThreeTest() {
		int[] arrInteger=new int[] {3,2,2};
		//MargoSortTwo.sort(arrInteger);
		MargoSortThree.quickSort(arrInteger);
		arrPrint(arrInteger);
	}

	public void simpleSelectSort() {
		MargoSortFour.simpleSelectSort(arrInteger);
		arrPrint(arrInteger);
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

package com.yb.project.algorithm.one.nowcoder.exam2;

import java.util.Scanner;

public class YbExam1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int length = sc.nextInt();
			if (length > 1000) {
				length = 999;
			}
			int[] nums = new int[length];
			int begin = -1; // 下标
			int f = length; // 数组中
			while (f > 1) {
				for (int i = 0; i < length; i++) {
					if (nums[i] != -1) {
						begin++;
						if (begin == 2) {
							f--;
							nums[i] = -1;
							begin = -1;
						}
					}

				}
			}
			for (int i = 0; i < length; i++) {
				if (nums[i] != -1) {
					System.out.println(i);
					break;
				}
			}
		}
		sc.close();
	}
}



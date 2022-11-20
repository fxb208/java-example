package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.Scanner;

/**
 * 密码验证合格程序
 * @author fxb20
 *
 */
public class YbHJ20 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			String password=sc.nextLine();
			int result=0;
			boolean qualified=false;
			boolean repeat=false;
			for(int i=0;i<password.length();i++) {
				if(Character.isUpperCase(password.charAt(i))) {
					result=result|1;
				}else if(Character.isLowerCase(password.charAt(i))) {
					result=result|2;
				}else if(Character.isDigit(password.charAt(i))) {
					result=result|4;
				}else{
					result=result|8;
				}
				if(result==15 || result==14 || result==7 || result==13) {
					qualified=true;
				}
				if(i+3<=password.length() && password.lastIndexOf(password.substring(i, i+3))-i>3) {
					repeat=true;
					break;
				};
			}
			if(qualified && password.length()>8 && !repeat) {
				System.out.println("OK");
			}else{
				System.out.println("NG");
			}	
		}
		sc.close();
	}
}

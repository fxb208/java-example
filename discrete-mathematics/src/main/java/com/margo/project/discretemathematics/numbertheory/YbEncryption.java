package com.margo.project.discretemathematics.numbertheory;


import org.junit.jupiter.api.Test;

public class YbEncryption {
	
	@Test
	public void encryption(){
		String str="I LOVE YOU";
		char[] res=new char[str.length()];
		for(int i=0;i<str.length();i++) {
			res[i]=str.charAt(i);
		}
		System.out.println(res);
	}
}

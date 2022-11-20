package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * HJ36 字符串加密
 * @author fxb20
 * 
 * a B C D E F G h i J K L M n o P Q R S T U V W X Y Z
 * n i h a o B C D E F G J K L M P Q R S T U V W X Y Z
 *
 */
public class YbHJ36 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String key=sc.nextLine();
		String str=sc.nextLine();
		String dic="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Map<Character, Character> dicMap=new HashMap<Character, Character>();
		//密钥中的字母过滤
		ArrayList<Character> lst=new ArrayList<Character>();
		key=key.toUpperCase();
		for(int i=0;i<key.length();i++) {
			if(!lst.contains(key.charAt(i))) {
				lst.add(key.charAt(i));
			}
		}
		//不在密钥中的字母
		ArrayList<Character> lstSub=new ArrayList<Character>();
		for(int j=0;j<dic.length();j++) {
			if(!lst.contains(dic.charAt(j))){
				lstSub.add(dic.charAt(j));
			}
		}
		lst.addAll(lstSub);
		
		//构建翻译map
		for(int i=0;i<lst.size();i++) {
			dicMap.put(dic.charAt(i), lst.get(i));
			dicMap.put(Character.toLowerCase(dic.charAt(i)), Character.toLowerCase(lst.get(i)));
		}
		StringBuffer sb=new StringBuffer();
		for(int k=0;k<str.length();k++) {
			sb.append(dicMap.get(str.charAt(k)));
		}
		System.out.println(sb.toString());
		sc.close();
	}
}

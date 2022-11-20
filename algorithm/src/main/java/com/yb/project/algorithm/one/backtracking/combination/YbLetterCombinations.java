package com.yb.project.algorithm.one.backtracking.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 2 abc
 * 3 def
 * 4 ghi
 * 5 jkl
 * 6 mno
 * 7 pqrs
 * 8 tuv
 * 9 wxyz
 * 
 * 
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fxb20
 *
 */
public class YbLetterCombinations {
	
	public static void main(String[] args) {
		YbLetterCombinations yb=new YbLetterCombinations();
		System.out.println(yb.letterCombinations("23"));
	}
	
    public List<String> letterCombinations(String digits) {
    	int n=digits.length();
    	int[] nums=new int[n];
    	for(int i=0;i<n;i++) {
    		nums[i]=Integer.parseInt(String.valueOf(digits.charAt(i)) );
    	}
    	//排序
    	//Arrays.sort(nums);
    	
    	String[] arr=new String[8];
		arr[0]="abc"; //2
		arr[1]="def"; //3
		arr[2]="ghi";
		arr[3]="jkl";
		arr[4]="mno";
		arr[5]="pqrs";
		arr[6]="tuv";
		arr[7]="wxyz";
		List<String> result=new LinkedList<String>();
    	if(nums.length==0) {
    		return result;
    	}
		List<Character> path=new ArrayList<Character>();
		backtracking(n,result,path,arr,nums,0);
    	return result;
    }
    
    /**
     * abc
     * def
     * @param n
     * @param result
     * @param path
     * @param arr
     * @param nums
     * @param idx
     */
    public void backtracking(int n,List<String> result,List<Character> path,String[] arr,int[] nums,int idx) {
    	if(path.size()==n) {
    		char[] cArr=new char[n];
    		for(int i=0;i<n;i++) {
    			cArr[i]=path.get(i);
    		}
    		result.add(new String(cArr));
    		return;
    	}
    	for(int i=idx;i<nums.length;i++) {
    		String str=arr[nums[idx]-2];
    		for(int j=0;j<str.length();j++) {
    			path.add(str.charAt(j));
    			backtracking(n,result,path,arr,nums,i+1);
    			path.remove(path.size()-1);
    		}
    		
    	}
    }
    
}

package com.yb.project.algorithm.one.backtracking.partition;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原ip地址
 * @author fxb20
 * 
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
 * 这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 来源：力扣（LeetCode）
 * 
 * 链接：https://leetcode.cn/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbRestoreIpAddresses {
	
	public static void main(String[] args) {
		YbRestoreIpAddresses yb=new YbRestoreIpAddresses();
		System.out.println(yb.restoreIpAddresses("25525511135"));
	}
	
    public List<String> restoreIpAddresses(String s) {
    	List<String> result=new ArrayList<String>();
    	List<String> path=new ArrayList<String>(); 
    	backtrack(result,path,0,s);
    	return result;
    }
    
    public void backtrack(List<String> result,List<String> path,int idx,String s) {
    	if(path.size()==4 || idx==s.length()) {
    		if(path.size()==4 && idx==s.length()) {
    			StringBuilder sb=new StringBuilder();
        		for(int i=0;i<path.size();i++) {
        			sb.append(path.get(i));
        			if(i<path.size()-1) {
        				sb.append(".");
        			}
        		}
        		if(sb.toString().length()-3==s.length()) {
        			result.add(sb.toString());	
        		}	
    		}
    		return;
    	}
    	for(int i=idx;i<s.length() && idx+4>i;i++) {
    		String cp=s.substring(idx, i+1);
    		if(cp.length()==1 || ((!cp.startsWith("0")) && Integer.parseInt(cp)<256)) {
    			path.add(s.substring(idx, i+1));
    			backtrack(result,path,i+1,s);
    			path.remove(path.size()-1);	
    		}
			
		}
    }
}

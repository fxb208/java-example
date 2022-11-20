package leetcode.od.general;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * HJ77 火车进站
 */
public class HJ77 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        int length = sc.nextInt();
//        int[] arr = new int[length];
//        for(int i=0;i<length;i++){
//            arr[i]=sc.nextInt();
//        }
        int[] arr=new int[]{1,2,3};
        Stack<Integer> stack = new Stack<>();
        List<String> res = new LinkedList<>();
        dfs(res,stack,arr,0,"");
        Collections.sort(res);
        for (String str : res) {
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<str.length();i++){
                sb.append(str.charAt(i)).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    public static void dfs(List<String> res,Stack<Integer> stack,int[] arr,int idx,String str){
        if(str.length()==arr.length){
            res.add(str);
        }
        if(!stack.isEmpty()){
            int temp = stack.pop();
            dfs(res,stack,arr,idx,str+temp+" ");
            stack.push(temp);
        }
        if(idx<arr.length){
            stack.push(arr[idx]);
            dfs(res,stack,arr,idx+1,str);
            stack.pop();
        }

    }

}

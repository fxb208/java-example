package leetcode.od.general;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * HJ64 MP3光标位置
 */
public class HJ64 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String command = in.next();
        int res=1;
        if(len<=4){
            for(int i=0;i<command.length();i++){
                if(command.charAt(i)=='U' && res==1){
                    res=len;
                }else if((command.charAt(i)=='U' && res>1)){
                    res--;
                }else if(command.charAt(i)=='D' && res==len){
                    res=1;
                }else if(command.charAt(i)=='D' && res<len){
                    res++;
                }
            }
            if(len==1){
                System.out.println(1);
            }else if(len==2){
                System.out.println(1+" "+2);
            }else if(len==3){
                System.out.println(1+" "+2+" "+3);
            }else{
                System.out.println(1+" "+2+" "+3+" "+4);
            }
            System.out.println(res);
        }else{
            LinkedList<Integer> lst = new LinkedList<>();
            lst.add(1);
            lst.add(2);
            lst.add(3);
            lst.add(4);
            for(int i=0;i<command.length();i++){
                if(command.charAt(i)=='U' && res==1){
                    lst.clear();
                    lst.add(len-3);
                    lst.add(len-2);
                    lst.add(len-1);
                    lst.add(len);
                    res=len;
                }else if(command.charAt(i)=='D' && res == len){
                    lst.clear();
                    lst.add(1);
                    lst.add(2);
                    lst.add(3);
                    lst.add(4);
                    res=1;
                }else if(command.charAt(i)=='U' && res>lst.get(0)){
                    res--;
                }else if(command.charAt(i)=='U' && res==lst.get(0)){
                    res--;
                    lst.pollLast();
                    lst.addFirst(res);
                }else if(command.charAt(i)=='D' && res<lst.get(3)){
                    res++;
                }else if(command.charAt(i)=='D' && res==lst.get(3)){
                    res++;
                    lst.pollFirst();
                    lst.addLast(res);
                }
            }
            System.out.println(lst.get(0)+" "+lst.get(1)+" "+lst.get(2)+" "+lst.get(3));
            System.out.println(res);
        }
    }
}

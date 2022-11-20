package leetcode.od.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ48 {
    /**
     * 5 2 3 2 4 3 5 2 1 4 3
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int head = in.nextInt();
        List<Integer> res = new ArrayList<>();
        res.add(head);
        for(int i=0;i<len-1;i++){
            int newVal = in.nextInt();
            int oldVal = in.nextInt();
            int l=res.indexOf(oldVal);
            res.add(l+1,newVal);
        }
        int del = in.nextInt();
        res.remove(res.indexOf(del));
        StringBuilder sb = new StringBuilder();
        for(Integer value : res){
            sb.append(value).append(" ");
        }
        System.out.print(sb.toString());
    }

}

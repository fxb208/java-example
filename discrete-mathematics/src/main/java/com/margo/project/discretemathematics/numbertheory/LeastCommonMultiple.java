package com.margo.project.discretemathematics.numbertheory;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            List<Integer> list1 = new ArrayList<>();
            prime(list1,a);
            Map<Integer,Integer> map1 =new HashMap<>();
            for(int i : list1){
                if(map1.containsKey(i)){
                    map1.put(i,map1.get(i)+1);
                }else{
                    map1.put(i,1);
                }
            }
            List<Integer> list2 = new ArrayList<>();
            prime(list2,b);
            Map<Integer,Integer> map2 =new HashMap<>();
            for(int i : list2){
                if(map2.containsKey(i)){
                    map2.put(i,map2.get(i)+1);
                }else{
                    map2.put(i,1);
                }
            }
            long result=1;
            for(int i:list1){
                result=result*(long)i;
            }
            for(int i:map2.keySet()){
                if(map1.get(i)==null || map2.get(i)>map1.get(i)){
                    int n=map2.get(i)-(map1.get(i)!=null?map1.get(i):0);
                    for(int j=0;j<n;j++){
                        result=result*(long)i;
                    }
                }

            }
            System.out.println(result);
        }
    }

    public static void prime(List<Integer> list,int s){
        long n=(long)Math.sqrt(s);
        for(int i=2;i<n;i++){
            while(s%i==0){
                list.add(i);
                s/=i;
            }
        }
        if(s !=1){
            list.add(s);
        }
    }
}

package leetcode.od2.map;

import java.util.HashMap;
import java.util.Scanner;

public class HJ59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //String word = in.nextLine();
        String word = "asdfasdfo";
        HashMap<Character,int[]> map = new HashMap<>();
        for(int i=0;i<word.length();i++){
            char key = word.charAt(i);
            if(map.containsKey(key)){
                int[] arr = map.get(key);
                arr[0]++;
            }else{
                int[] arr = new int[2];
                arr[0]=1;
                arr[1]=i;
                map.put(key,arr);
            }
        }
        int res = word.length();
        for(char key:map.keySet()){
            if(map.get(key)[0]==1){
                res = Math.min(res,map.get(key)[1]);
            }
        }
        System.out.println(res==word.length()?"-1":word.charAt(res));
    }
}

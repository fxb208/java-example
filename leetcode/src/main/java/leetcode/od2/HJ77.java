package leetcode.od2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * HJ77 火车进站
 *
 * 描述
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，
 * 火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。 进阶：时间复杂度：O(n!)\O(n!) ，空间复杂度：O(n)\O(n) 输入描述：
 * 第一行输入一个正整数N（0 < N <= 10），第二行包括N个正整数，范围为1到10。
 *
 * 输出描述： 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 */
public class HJ77 {
    public static void main(String[] args) {
        //
        Scanner in = new Scanner(System.in);
//        int len = in.nextInt();
//        int[] arr = new int[len];
//        for(int i=0;i<len;i++){
//            arr[i]=in.nextInt();
//        }
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),new LinkedList<>(),arr,0);
        for(int i=0;i<res.size();i++){
            List<Integer> temp = res.get(i);
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<temp.size();j++){
                sb.append(temp.get(j)).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> path, Deque<Integer> stack, int[] arr, int idx){
        if(path.size()==arr.length){
            res.add(new ArrayList<>(path));
            return;
        }

        if(stack.peekLast() !=null){
            Integer num = stack.pollLast();
            path.add(num);
            backtrack(res,path,stack,arr,idx);
            stack.add(num);
            path.remove(path.size()-1);
        }

        if(idx<arr.length){
            stack.add(arr[idx]);
            backtrack(res,path,stack,arr,idx+1);
            stack.pollLast();
        }


    }
}

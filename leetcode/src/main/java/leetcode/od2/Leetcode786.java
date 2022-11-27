package leetcode.od2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 786. 第 K 个最小的素数分数
 */
public class Leetcode786 {

    public static void main(String[] args) {
        //
        Leetcode786 yb = new Leetcode786();
        int[] arr = new int[]{1,2,3,5};
        int k =3;
        yb.kthSmallestPrimeFraction(arr,k);
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> {
           return o1[1]*o2[0]-o1[0]*o2[1];
        });
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(queue.size()<k){
                    queue.add(new int[]{arr[i],arr[j]});
                }else{
                    int[] temp = queue.peek();
                    if(temp[0]*arr[j]>arr[i]*temp[1]){
                        queue.poll();
                        queue.add(new int[]{arr[i],arr[j]});
                    }
                }
            }
        }
        // dfs(queue, k, arr, 0, new ArrayList<Integer>());
        int[] res = queue.peek();
        if(queue.peek()!=null){
            res=queue.poll();
        }
        return res;
    }

    public static void dfs(PriorityQueue<int[]> queue, int k, int[] arr, int idx, List<Integer> path){
        if(path.size()==2){
            if(queue.size()<k){
                queue.add(new int[]{path.get(0),path.get(1)});
            }else{
                int[] temp = queue.peek();
                if(temp[0]*path.get(1)>path.get(0)*temp[1]){
                    queue.poll();
                    queue.add(new int[]{path.get(0),path.get(1)});
                }
            }
            return;
        }
        for(int i=idx;i<arr.length;i++){
            path.add(arr[i]);
            dfs(queue,k,arr,i+1,path);
            path.remove(path.size()-1);
        }
    }
}

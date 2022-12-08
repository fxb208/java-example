package leetcode.od3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 剑指 Offer II 115. 重建序列
 * 给定一个长度为 n 的整数数组 nums ，其中 nums 是范围为 [1，n] 的整数的排列。
 * 还提供了一个 2D 整数数组 sequences ，其中 sequences[i] 是 nums 的子序列。
 * 检查 nums 是否是唯一的最短 超序列 。最短 超序列 是 长度最短 的序列，并且所有序列 sequences[i] 都是它的子序列。
 * 对于给定的数组 sequences ，可能存在多个有效的 超序列 。
 *
 * 例如，对于 sequences = [[1,2],[1,3]] ，有两个最短的 超序列 ，[1,2,3] 和 [1,3,2] 。
 * 而对于 sequences = [[1,2],[1,3],[1,2,3]] ，唯一可能的最短 超序列 是 [1,2,3] 。
 * [1,2,3,4] 是可能的超序列，但不是最短的。
 * 如果 nums 是序列的唯一最短 超序列 ，则返回 true ，否则返回 false 。
 * 子序列 是一个可以通过从另一个序列中删除一些元素或不删除任何元素，而不改变其余元素的顺序的序列。
 */
public class OfferII115 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
//        int[] nums = new int[]{1,2,3,4};
//        int[][] sequences = new int[][]{{1,2,4},{1,3,4}};
        int[] nums = new int[]{4,1,5,2,6,3};
        int[][] sequences = new int[][]{{5,2,6,3},{4,1,5,2}};
        OfferII115 yb = new OfferII115();
        System.out.println(yb.sequenceReconstruction(nums,sequences));
    }

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int[] degree = new int[nums.length+1];
        Set<Integer>[] sets = new Set[nums.length+1];
        for(int i=0;i<sets.length;i++){
            sets[i]=new HashSet<>();
        }
        for(int i=0;i<sequences.length;i++){
            int[] arr = sequences[i];
            for(int j=0;j<arr.length-1;j++){
                degree[arr[j+1]]++;
                sets[arr[j]].add(arr[j+1]);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1;i<degree.length;i++){
            if(degree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            if(queue.size()>1){
                return false;
            }
            Set<Integer> set = sets[queue.poll()];
            for(Integer num : set){
                degree[num]--;
                if(degree[num]==0){
                    queue.offer(num);
                }
            }
        }
        return true;
    }
}

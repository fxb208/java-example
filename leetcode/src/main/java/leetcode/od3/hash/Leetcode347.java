package leetcode.od3.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > queue.peek()[1]) {
                    queue.poll();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int idx = k - 1;
        while (!queue.isEmpty()) {
            res[idx] = queue.poll()[0];
            idx--;
        }
        return res;
    }
}

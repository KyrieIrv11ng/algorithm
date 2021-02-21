package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> (map.get(a) - map.get(b)));//按照每个数出现次数排序
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for (Integer integer : map.keySet()) {
            pq.offer(integer);
            if(pq.size()>k){
                pq.poll();
            }
        }
        for (int i = res.length-1; i >=0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }
}

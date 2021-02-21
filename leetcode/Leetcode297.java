package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode297 {
    public int findShortestSubArray(int[] nums) {
        int res = Integer.MAX_VALUE;
        Map<Integer,Integer> count = new HashMap<>();
        Map<Integer,Integer> firstIndex = new HashMap<>();
        Map<Integer,Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
            lastIndex.put(nums[i],i);
            if(!firstIndex.containsKey(nums[i])){
                firstIndex.put(nums[i],i);
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,count.get(nums[i]));
        }
        for (Integer integer : count.keySet()) {
            if(count.get(integer)==max){
                res = Math.min(res,lastIndex.get(integer)-firstIndex.get(integer)+1);
            }
        }
        return res;
    }
}

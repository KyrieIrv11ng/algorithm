package leetcode.哈希;

import java.util.HashMap;
import java.util.Map;

public class Leetcode594 {
    public int findLHS(int[] nums) {
        int longest = 0;
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        for (Integer integer : m.keySet()) {

            if(m.containsKey(integer+1)){
                longest = Math.max(longest,m.get(integer)+m.get(integer+1));
            }
        }
        return longest;
    }
}

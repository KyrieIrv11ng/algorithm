package 剑指offer.面试题39;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i],m.getOrDefault(nums[i], 0)+1);
            if(m.get(nums[i])>nums.length/2){
                return nums[i];
            }
        }
        return 0;
    }
}

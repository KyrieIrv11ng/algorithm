package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        int longgest = 0;
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i],1);
        }
        for (Integer integer : m.keySet()) {
            if(!m.containsKey(integer-1)){
                int temp = 1;
                while(m.containsKey(integer+1)){
                    temp++;
                    integer++;
                }
                longgest = Math.max(longgest,temp);
            }
        }
        return longgest;
    }
}

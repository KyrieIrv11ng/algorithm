package 剑指offer.面试题3;

import java.util.HashSet;
import java.util.Set;

public class Solution4 {
    public int findRepeatNumber(int[] nums) {
        Set s = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(s.contains(nums[i])){
                return nums[i];
            }else{
                s.add(nums[i]);
            }
        }
        return -1;

    }

}

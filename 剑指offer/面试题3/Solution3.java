package 剑指offer.面试题3;

import java.util.HashMap;
import java.util.Map;
/*
时间复杂度O(N),空间复杂度O(N)，使用额外hashmap数据结构
 */
public class Solution3 {
    public int findRepeatNumber(int[] nums) {
        Map m = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(m.containsValue(nums[i])){
                return nums[i];
            }else{
                m.put(i,nums[i]);
            }
        }
        return -1;
    }
}

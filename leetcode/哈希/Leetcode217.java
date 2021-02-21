package leetcode.哈希;

import java.util.HashSet;
import java.util.Set;

public class Leetcode217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
}

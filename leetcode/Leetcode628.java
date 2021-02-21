package leetcode;

import java.util.Arrays;

public class Leetcode628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int sum1 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int sum2 = nums[0]*nums[1]*nums[nums.length-1];
        return Math.max(sum1,sum2);
    }
}

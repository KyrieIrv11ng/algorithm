package 剑指offer.面试题42;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
    //空间优化
    public int maxSubArray1(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int ans = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans+nums[i],nums[i]);
            max = Math.max(ans,max);
        }
        return max;
    }
}

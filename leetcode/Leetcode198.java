package leetcode;

import java.util.Arrays;

public class Leetcode198 {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);  //边界条件，1间房间最大值就是当前房间，两间房的最大值就是其中最大值
        for(int i = 2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }
}

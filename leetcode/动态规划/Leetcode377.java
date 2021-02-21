package leetcode.动态规划;

import java.util.Arrays;

public class Leetcode377 {
    //回溯，超时
    int res = 0;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums,target);
        return res;
    }

    public void dfs(int[] nums,int target){
        if(target==0){
            res++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(target-nums[i]<0){
                continue;
            }
            dfs(nums,target-nums[i]);
        }
    }
    //爬楼梯问题 楼梯的阶数一共为target，一次可以走的步数为nums[i]。 一共有多少种走法？问题搞定。
    public int combinationSum41(int[] nums, int target){
        int dp[] = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i-nums[j]>=0){
                    dp[i] = dp[i-nums[j]]+dp[i];
                }
            }
        }
        return dp[dp.length-1];
    }
}

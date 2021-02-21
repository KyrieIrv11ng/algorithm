package leetcode;

import java.util.Arrays;

public class Leetcode746 {
    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length==0){
            return 0;
        }
        int[] dp = new int[cost.length+2];
        dp[0] = 0;
        dp[1] = cost[0];
        for (int i = 1; i < cost.length; i++) {
            dp[i+1] = Math.min(dp[i],dp[i-1]) + cost[i];
        }
        dp[dp.length-1] = Math.min(dp[dp.length-2],dp[dp.length-3]);
        return dp[dp.length-1];
    }

    //官方解
    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    //迭代法，滚动数组
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] a = new int[]{10,15,20};
        System.out.println(minCostClimbingStairs(a));
    }
}

package 剑指offer.面试题10_2;

public class Solution {
    public int numWays(int n) {
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
            dp[i] = dp[i]%1000000007;
        }
        return dp[n];
    }
}

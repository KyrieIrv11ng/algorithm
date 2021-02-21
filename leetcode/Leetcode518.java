package leetcode;

import java.util.Arrays;

public class Leetcode518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if(j-coins[i]>=0){
                    dp[j] = dp[j-coins[i]]+dp[j];
                }
            }
        }
        return dp[amount];
    }
}

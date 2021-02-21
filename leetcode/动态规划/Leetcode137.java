package leetcode.动态规划;

import java.util.Arrays;

public class Leetcode137 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n==0){
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if(ratings[i]>ratings[i-1]){
                dp[i] = dp[i-1]+1;
            }
        }

        for(int i = n-2;i>=0;i--){
            if ((ratings[i]>ratings[i+1])){
                dp[i] = Math.max(dp[i],dp[i+1]+1);
            }
        }
        int res = 0;
        for (int value : dp) {
            res = res + value;
        }
        return res;
    }
}

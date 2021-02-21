package 剑指offer.面试题63;

public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
            }else if(prices[i]-min>max){
                max = prices[i] - min;
            }
        }
        return max;
    }

    //动态规划
    public int maxProfit1(int[] prices) {
        int[] dp = new int[prices.length];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i-1],prices[i]-minPrice);
            minPrice = Math.min(prices[i],minPrice);
        }
        return dp[dp.length-1];
    }
}

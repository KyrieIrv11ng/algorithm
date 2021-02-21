package leetcode.动态规划;

public class Leetcode123 {
    public int maxProfit(int[] prices) {
        int[][] buy = new int[prices.length][3];
        int[][] sell = new int[prices.length][3];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i < 3; i++) {
            sell[0][i] = buy[0][i] = Integer.MIN_VALUE/2;
        }

        for (int i = 1; i < prices.length; i++) {
            buy[i][0] = Math.max(buy[i-1][0],sell[i-1][0]-prices[i]);  //在没有交易的时候看那一天买入花的钱最少
            for (int j = 1; j < 3; j++) {
                buy[i][j] = Math.max(buy[i-1][j],sell[i-1][j]-prices[i]);
                sell[i][j] = Math.max(buy[i-1][j-1]+prices[i],sell[i-1][j]);//只有当卖掉的时候，交易的次数才会增加
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(sell[prices.length-1][i],max);
        }
        return max;
    }
}

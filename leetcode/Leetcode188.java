package leetcode;

import java.util.Arrays;

public class Leetcode188 {
    //题解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iv-by-8xtkp/
    public int maxProfit(int k, int[] prices) {
        if (prices==null||prices.length==0){
            return 0;
        }
        k = Math.min(k,prices.length/2);
        int[][] buy = new int[prices.length][k+1];
        int[][] sell = new int[prices.length][k+1];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        int max = 0;
        for(int i = 1;i <= k;i++){
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE/2;
        }
        for(int i = 1;i<prices.length;i++){
            buy[i][0] = Math.max(buy[i-1][0],sell[i-1][0]-prices[i]);
            for(int j = 1;j<=k;j++){
                buy[i][j] = Math.max(buy[i-1][j],sell[i-1][j]-prices[i]);
                sell[i][j] = Math.max(sell[i-1][j],buy[i-1][j-1]+prices[i]);
            }
        }
        System.out.println(Arrays.toString(sell));
        System.out.println(Arrays.toString(buy));
        for (int i = 0; i <= k; i++) {
            max = Math.max(sell[prices.length-1][i],max);
        }

        return max;
    }
}

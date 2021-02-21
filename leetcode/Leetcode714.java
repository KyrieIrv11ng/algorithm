package leetcode;

public class Leetcode714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //dp[i][0]表示i当天没有股票时的最大利润
        //dp[i][1]表示i当天有股票时的最大利润
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);     //前一天没买股票利润和前一天买股票i当天卖掉股票所得利润的最大值
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);     //前一天买股票利润和前一天买股票i当天买股票所得利润的最大值
        }
        return dp[n-1][0];
    }
    //注意到在状态转移方程中，dp[i][0] 和 dp[i][1]
    // 只会从 dp[i−1][0] 和 dp[i−1][1] 转移而来，
    // 因此我们不必使用数组存储所有的状态，而是使用两个变量
    // sell 以及 buy 分别表示
    // dp[..][0] 和 dp[..][1] 直接进行状态转移即可。

    //官方：
    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

    //贪心
    //题解
    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-han-sh-rzlz/
    public int maxProfit3(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;  //定义买入股票=当天股票价+手续费
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {    //如果当前股票价和手续费比之前买入的还要少，就此时买入
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {       //如果当前股票价大于之前买入，可以卖出，但可能会提前卖出
                profit += prices[i] - buy;  //卖出
                buy = prices[i];    //假如提前卖出，可以当前再买入，后面再卖出，buy为当前股票价格
            }
        }
        return profit;
    }


}

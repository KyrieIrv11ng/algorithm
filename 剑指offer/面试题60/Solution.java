package 剑指offer.面试题60;

public class Solution {
    //动态规划
    public double[] dicesProbability(int n) {
        int num = 6*n;
        double[] res = new double[num-n+1];
        //i表示第几个骰子，j表示当前数的和为多少
        int[][] dp = new int[n+1][num+1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for(int j = i;j<=i*6;j++){
                for (int k = 1; k <= 6; k++) {
                    if(j-k<1){
                        break;
                    }
                    dp[i][j] = dp[i][j]+dp[i-1][j-k];
                }
            }
        }
        double fenMu = Math.pow(6,n);
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][i+n]/fenMu;
        }
        return res;
    }
    //空间优化
    public double[] dicesProbability1(int n) {
        int num = 6*n;
        double[] res = new double[num-n+1];
        //i表示第几个骰子，j表示当前数的和为多少
        int[] dp = new int[num+1];
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for(int j = i*6;j>=i;j--){
                dp[j] = 0;//这里表示从后往前算要把当前的状态置为0，不然会拿到之前的状态；
                for (int k = 1; k <= 6; k++) {
                    if(j-k<i-1){
                        break;
                    }
                    dp[j] = dp[j]+dp[j-k];
                }
            }
        }
        double fenMu = Math.pow(6,n);
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[i+n]/fenMu;
        }
        return res;
    }
}

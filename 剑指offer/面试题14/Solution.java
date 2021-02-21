package 剑指offer.面试题14;

public class Solution {
    public static int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3;i <= n;i++){
            for(int j = 1;j<i;j++){
                int a = j*(i-j);//两边绳子不分
                int b = dp[j]*dp[i-j];//两边绳子都分
                int c = j*dp[i-j];//一边绳子分
                int d = dp[j]*(i-j);//一边绳子分
                dp[i] = Math.max(dp[i],Math.max(a,Math.max(b,Math.max(c,d))));//比大小
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(cuttingRope(4));
    }
}
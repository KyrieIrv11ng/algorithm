package leetcode.回溯DFS;

import java.util.Arrays;

public class Leetcode322 {
    //回溯法（超时）
    //未剪枝只过15个用例
    //类似39题做法，剪枝
    //剪枝后还是超时
    //剪枝后过93个用例
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0){
            return -1;
        }
        Arrays.sort(coins);
        helper(coins,amount,0,0);
        if(ans==Integer.MAX_VALUE)return -1;
        return ans;
    }

    public void helper(int[] coins, int amount,int count,int begin){
        if(amount == 0){
            ans = Math.min(ans,count);
        }

        for (int i = begin; i < coins.length; i++) {
            if(amount-coins[i]<0){
                break;
            }
            helper(coins,amount-coins[i],count+1,i);
        }
    }
}

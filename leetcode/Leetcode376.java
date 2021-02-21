package leetcode;

import java.util.Arrays;

public class Leetcode376 {
    //动态规划 迭代
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                up = down+1;            //如果当前的值比前一个值大，即为上升的，
                                            // 那么前面第一个下降的加上此时上升的即为最后的波动序列
            }else if(nums[i]<nums[i-1]){
                down = up +1;
            }
        }
        return Math.max(up,down);
    }
    //贪心
    public int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevdiff = nums[1] - nums[0];
        int res = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                res++;
                prevdiff = diff;
            }
        }
        return res;
    }
}

package leetcode.动态规划;

public class Leetcode213 {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        //要么不抢最后一家的，要么不抢第一家的，来实现不成环，最后比哪个大就怎么抢
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));

    }

    public int rob(int[] nums,int start,int end){
        int pre1 = 0;       //i-2时候的状态
        int pre2 = 0;       //i-1时候的状态
        for (int i = start; i <= end; i++) {
            int cur = Math.max(pre2,pre1+nums[i]);      //要么抢前一家的，今天不抢，要么抢前两家的
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }
}

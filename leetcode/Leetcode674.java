package leetcode;

public class Leetcode674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int max = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                count++;
            }else{
                count = 1;
            }
            max = Math.max(count,max);
        }
        return max;
    }
}

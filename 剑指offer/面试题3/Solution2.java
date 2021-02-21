package 剑指offer.面试题3;

import org.junit.Assert;
import org.junit.Test;
/*
二分法，时间复杂度O(logn)，空间复杂度O(1)，不需要改变原数组，方法有点问题
 */
class Solution2 {
    public int findRepeatNumber(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start<end){
            mid = start + (end - start)/2;
            int count = countnum(nums,start,mid);
            if( count > (mid -start ) ){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;

    }

    public static int countnum(int[] nums,int small,int large){
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] <= large && nums[i] >= small){
                count++;
            }
        }
        return count;
    }


}



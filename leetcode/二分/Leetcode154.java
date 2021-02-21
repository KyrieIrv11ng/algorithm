package leetcode.二分;

public class Leetcode154 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l + (r - l)/2;
            if(nums[mid]<nums[r]){      //最小值在左边
                r = mid;
            }else if(nums[mid]>nums[r]){        //最小值在右边
                l = mid + 1;
            }else{
                r--;            //如果有重复的，右指针就往左边移动一位，去重
            }
        }
        return nums[l];
    }
}

package leetcode.二分;

public class Leetcode162 {
    //需要与右邻居作对比，所以选择2模板
    //思路：有上坡必有下坡 或者一路上坡，边界为-oo
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int lo = 0;
        int hi = nums.length-1;
        while(lo<hi){
            int mid = lo+ (hi-lo)/2;
            if(nums[mid]<nums[mid+1]){//因为向下取整，只有两个数的情况下，
                                // 所以mid+1存在的，不会出现溢出的情况，当mid<mid+1时，
                                // 说明右边有山坡，所以，山顶往右移一位
                lo = mid+1;
            }else{              //不然山坡就在左边
                hi = mid;
            }
        }
        return lo;
    }
}

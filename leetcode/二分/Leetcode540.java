package leetcode.二分;

public class Leetcode540 {
    //首先，只有一个数这一位肯定在偶数位
    //在这个数前面的两个数的数，都是偶数在前，奇数在后
    //而在这个数后面的两个数的数，都是奇数在前，偶数在后
    //让m保持为偶数
    //并且始终保持L M R 为偶数
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int m = l + (r - l)/2;
            if(m%2==1){//如果是奇数，就向前移动一位
                m--;
            }
            if(nums[m] == nums[m+1]){//如果两个数相等，就说明此时这个数在当前m的后面[m+2，r]
                l = m+2;
            }else{
                r = m;
            }
        }
        return nums[l];
    }
}

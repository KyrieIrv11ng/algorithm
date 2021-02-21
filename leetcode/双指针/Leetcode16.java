package leetcode.双指针;

import java.util.Arrays;

public class Leetcode16 {
    //先排序, 然后遍历, 然后内部使用双指针, 时间复杂度应该是O(n²), 代码如下:
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length; i++) {
            int L = i+1;
            int R = nums.length-1;
            while(L<R){
                int sum = nums[i]+nums[L]+nums[R];
                if(Math.abs(res-target)>Math.abs(sum-target)){
                    res = sum;
                }
                if(sum<target){
                    L++;
                }else if(sum>target){
                    R--;
                }else return target;
            }
        }
        return res;
    }
}

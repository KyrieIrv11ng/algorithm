package 剑指offer.面试题57_1;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==target){
                return new int[]{nums[i],nums[j]};
            }else if(nums[i]+nums[j]<target){
                i++;
            }else{
                j--;
            }
        }
        return new int[]{-1,-1};
    }
}

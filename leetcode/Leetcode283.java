package leetcode;

public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        if(nums==null){
            return ;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                swap(nums,i,j++);
            }
        }

    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

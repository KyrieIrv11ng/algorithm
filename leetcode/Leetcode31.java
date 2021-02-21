package leetcode;

import java.util.Arrays;

public class Leetcode31 {
    public void nextPermutation(int[] nums) {

        //从右到左找到右侧最小的一个数，再从右边向左找，找到比这个数大的第一个数，交换，然后从当前数右边开始重新排列
        int left = 0;
        int right = nums.length-1;
        boolean flag = true;
        for(int i = nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                left = i-1;
                for(int j = nums.length-1;j>left;j--){
                    if(nums[j]>nums[left]){
                        right = j;
                        swap(nums,left,right);
                        flag = false;
                        break;
                    }

                }
                break;
            }
        }
        int r = nums.length-1;
        int l = left+1;
        while(l<r){
            swap(nums,l++,r--);
        }
        if(flag){
            Arrays.sort(nums);
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

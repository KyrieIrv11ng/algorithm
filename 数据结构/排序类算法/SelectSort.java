package 数据结构.排序类算法;

import java.util.Arrays;

public class SelectSort {
    public static int[] selectSort(int[] nums){
        if(nums.length==0||nums.length<2){
            return nums;
        }
        for(int i = 0;i<nums.length;i++){
            int minIndex = i;           //把最开头的index作为最小数的index
            for(int j = i+1;j<nums.length;j++){
                minIndex = nums[minIndex]>nums[j]?j:minIndex;   //如果当前数小于minindex下的数，
                                                                // minindex为当前数的index
            }
            swap(nums,minIndex,i);        //交换minindex和i上的数，即把最小的数选择出来
        }
        return nums;
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {4,6,3,7,9,2,7,1,5};
        System.out.println(Arrays.toString((selectSort(arr))));
    }
}

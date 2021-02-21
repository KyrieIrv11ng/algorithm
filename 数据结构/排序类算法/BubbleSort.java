package 数据结构.排序类算法;

import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] nums){
        if(nums.length==0||nums.length<2){
            return nums;
        }
        for(int end = nums.length-1;end>0;end--){
            for(int i = 0;i<end;i++){
                if(nums[i]>nums[i+1]){
                    swap(nums,i,i+1);
                }
            }
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
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}

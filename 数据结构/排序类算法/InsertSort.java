package 数据结构.排序类算法;

import java.util.Arrays;

public class InsertSort {
    public static int[] insertSort(int[] nums){
        if(nums.length==0||nums.length<2){
            return nums;
        }
        for(int i = 1;i<nums.length;i++){   //默认第一个已经排好
            for(int j = i-1;j>=0&&nums[j+1]<nums[j];j--){
                swap(nums,j+1,j);
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
        System.out.println(Arrays.toString(insertSort(arr)));
    }
}

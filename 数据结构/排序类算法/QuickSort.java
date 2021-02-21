package 数据结构.排序类算法;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] nums,int left,int right){
        if(left<right){
            swap(nums,left+(int)(Math.random()*(right-left+1)),right);
            int[] p = partition(nums,left,right);
            quickSort(nums,left,p[0]-1);
            quickSort(nums,p[1]+1,right);
        }
    }

    public static int[] partition(int[] nums,int left,int right){
        int less = left-1;
        int more = right;
        while(left<more){
            if(nums[left]<nums[right]){
                swap(nums,++less,left++);
            }else if(nums[left]>nums[right]){
                swap(nums,--more,left);
            }else{
                left++;
            }
        }
        swap(nums,more,right);
        return new int[]{less+1,more};      //俩值，等于区的左边界和右边界
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,6,3,7,9,2,7,1,5};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

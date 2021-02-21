package 数据结构.排序类算法;

import java.util.Arrays;

public class MergeSort {
    public static int[]  mergrSort(int[] nums){
        if(nums.length < 2){
            return nums;
        }
        sort(nums,0, nums.length-1);
        return nums;
    }

    public static void sort(int[] nums,int left,int right){ //排序
        if(left == right){
            return;
        }
        int mid = left+((right-left)>>1);
        sort(nums,left,mid);
        sort(nums,mid+1,right);
        merge(nums,left,right,mid);
        
    }

    public static void merge(int[] nums, int left, int right, int mid){     //合并
        int[] help = new int[right-left+1];
        int temp = 0;
        int p = left;
        int q = mid + 1;
        while(p<=mid&&q<=right){
            help[temp++]=nums[p]<nums[q]?nums[p++]:nums[q++];
        }
        while(p<=mid){
            help[temp++]=nums[p++];
        }
        while(q<=right){
            help[temp++]=nums[q++];
        }
        for (int i = 0; i < help.length; i++) {
            nums[left+i]=help[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,6,3,7,9,2,7,1,5};
        System.out.println(Arrays.toString(mergrSort(arr)));
    }
}

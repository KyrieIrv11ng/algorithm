package 数据结构.排序类算法;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] nums){
        for(int i = 0;i<nums.length;i++){
            heapInsert(nums,i);
        }
        int heapsize = nums.length;
        swap(nums,0,--heapsize);
        while(heapsize>0){
            heapify(nums,0,heapsize);
            swap(nums,0,--heapsize);
        }
    }

    public static void heapInsert(int[] nums,int index){
        while(nums[index]>nums[(index-1)/2]){       //-1/2 = 0 依然会跳出循环
            swap(nums,index,(index-1)/2);
            index = (index-1)/2 ;
        }
    }

    public static void heapify(int[] nums,int index,int heapsize){
        int left = index*2+1;
        while (left<heapsize){
            int largest = left+1<heapsize&&nums[left+1]>nums[left]?left+1:left;
            largest = nums[index]>nums[largest]?index:largest;
            if(largest == index) break;
            swap(nums,largest,index);
            index = largest;
            left = index*2+1;
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,6,3,7,9,2,7,1,5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

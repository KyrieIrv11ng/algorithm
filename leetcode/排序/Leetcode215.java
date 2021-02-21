package leetcode.排序;

import java.util.PriorityQueue;

public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) ->(b-a));
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        for (int i = 1; i < k; i++) {
            pq.poll();
        }
        return pq.poll();
    }

    public int findKthLargest1(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        k = nums.length - k;
        while(left<right){
            int j = quickPartation(nums,left,right);
            if(j==k){
                break;
            }else if(j>k){
                right = j-1;
            }else{
                left = j+1;
            }
        }
        return nums[k];
    }

    public int quickPartation(int[] nums,int left,int right){
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
        return less+1;
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}

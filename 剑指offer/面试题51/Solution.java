package 剑指offer.面试题51;

public class Solution {
    public int reversePairs(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        return mergesort(nums,0,nums.length-1);
    }
    public int mergesort(int[] nums,int left,int right){
        if(left==right){
            return 0;
        }
        int mid = left+(right-left)/2;
        return mergesort(nums,left,mid)+mergesort(nums,mid+1,right)+merge(nums,left,mid,right);
    }

    public int merge(int[] nums,int left,int mid,int right){
        int res = 0;
        int[] help = new int[right-left+1];
        int p1 = left;
        int p2 = mid+1;
        int piont = 0;
        while(p1<=mid&&p2<=right){
            if(nums[p1]>nums[p2]){
                res = res+mid-p1+1;//如果左边大于右边，那么左边所有都大于右边
                help[piont++] = nums[p2++];
            }else{
                help[piont++] = nums[p1++];
            }
        }
        while(p1<=mid){
            help[piont++] = nums[p1++];
        }
        while(p2<=right){
            help[piont++] = nums[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            nums[left+i]=help[i];
        }
        return res;
    }
}

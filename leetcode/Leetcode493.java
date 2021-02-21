package leetcode;

public class Leetcode493 {
    public int reversePairs(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        return mergesort(nums,0,nums.length-1);
    }

    public int mergesort(int[] nums,int left,int right){        //归并排序
        if(right==left){
            return 0;
        }
        int mid = left+(right-left)/2;
        int leftnum = mergesort(nums,left,mid);
        int rightnums = mergesort(nums,mid+1,right);
        int mergenums = merge(nums,left,right,mid);
        return leftnum+rightnums+mergenums;
    }
    public int merge(int[] nums,int left,int right,int mid){        //合并
        int res = 0;
        int[] temp = new int[right-left+1];
        int p = 0;
        int i = left;
        int j = mid+1;
        while(i<=mid){
            while(j<=right&&(long)nums[i]>(long)nums[j]*2){         //找符合条件的数
                j++;
            }
            res = res+ j-mid-1;
            i++;
        }
        int p1 = left;                  //合并
        int p2 = mid+1;
        while(p1<=mid&&p2<=right){
            if(nums[p1]<nums[p2]){
                temp[p++] = nums[p1++];
            }else{
                temp[p++] = nums[p2++];
            }
        }
        while(p1<=mid){
            temp[p++] = nums[p1++];
        }
        while(p2<=right){
            temp[p++] = nums[p2++];
        }
        for (int k = 0; k < temp.length; k++) {
            nums[left+k]=temp[k];
        }
        return res;
    }
}

package leetcode;

import java.util.Arrays;

public class Leetcode34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums==null||nums.length==0){
            return res;
        }

        int L = 0;
        int R = nums.length-1;
        while(L<R){         //找第一个出现的
            int M = L+((R-L)>>1);
            if(nums[M]<target){
                L = M+1;
            }else{
                R = M;
            }
        }
        if(nums[L]!=target){
            return res;
        }else{
            res[0] = L;
        }
        L = 0;
        R = nums.length-1;
        while(L<R){     //找最后一个出现的
            int M = L+((R-L)>>1);
            if(nums[M]<=target){
                L = M+1;
            }else{
                R = M;
            }
        }
        if(nums[R]!=target){
            res[1] = R-1;
        }else{
            res[1] = R;
        }
        return res;
    }

    public static void main(String[] args) {
        int [] a = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(a,8)));

    }
}

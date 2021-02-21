package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    //算法流程：
    //特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
    //对数组进行排序。
    //遍历排序后数组：
    //若 nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
    //对于重复元素：跳过，避免出现重复解
    //令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行循环：
    //当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R移到下一位置，寻找新的解
    //若和大于 0，说明 nums[R] 太大，R左移
    //若和小于 0，说明 nums[L] 太小，L右移

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums ==null||nums.length<3){
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0) return res;
            if(i>0&&nums[i] == nums[i-1]){      //剪枝操作，如果当前数与前一个数相同，就跳过
                continue;
            }
            int L = i+1;
            int R = nums.length-1;
            while(L<R){
                if(nums[i]+nums[L]+nums[R]==0){
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    res.add(new ArrayList<>(list));
                    list.clear();
                    while(L<R&&nums[L]==nums[L+1]){     //于后一个相同跳过
                        L++;
                    }
                    while(L<R&&nums[R]==nums[R-1]){         //与前一个相同跳过
                        R--;
                    }
                    L++;
                    R--;
                }else if(nums[i]+nums[L]+nums[R]>0){
                    R--;
                }else{
                    L++;
                }
            }
        }
        return res;
    }
}

package leetcode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums==null||nums.length<4){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i] == nums[i-1]){      //剪枝操作，如果当前数与前一个数相同，就跳过
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if(j>i+1&&nums[j] == nums[j-1]){      //剪枝操作，如果当前数与前一个数相同，就跳过
                    continue;
                }
                int L = j+1;
                int R = nums.length-1;
                while(L<R){
                    int sum = nums[i]+nums[j]+nums[L]+nums[R];
                    if(sum==target){
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[L]);
                        list.add(nums[R]);
                        res.add(new ArrayList<>(list));
                        list.clear();
                        while(L<R&&nums[L]==nums[L+1]){
                            L++;
                        }while(L<R&&nums[R]==nums[R-1]){
                            R--;
                        }
                        L++;
                        R--;
                    }else if(sum<target){
                        L++;
                    }else{
                        R--;
                    }
                }
            }
        }
        return res;
    }
}

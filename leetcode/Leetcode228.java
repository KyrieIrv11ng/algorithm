package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode228 {
    public List<String> summaryRanges(int[] nums) {
        if(nums==null||nums.length==0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if((nums[i]+1)!=nums[i+1]){
                end = i;
                if(end==start){
                    res.add(nums[end]+"");
                }else{
                    res.add(nums[start]+"->"+nums[end]);
                }
                start = i+1;
            }
        }
        end = nums.length-1;
        if(end==start){
            res.add(nums[end]+"");
        }else{
            res.add(nums[start]+"->"+nums[end]);
        }
        return res;
    }
    //官方题解
    public List<String> summaryRanges1(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i, j = 0; j < nums.length; ++j){
            i = j;
            // try to extend the range [nums[i], nums[j]]
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                ++j;
            // put the range into the list
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
        }
        return summary;
    }
}

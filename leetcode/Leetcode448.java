package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while(nums[i]!=i+1){
                if(nums[i]==nums[nums[i]-1]){
                    break;
                }
                swap(nums,i,nums[i]-1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(i+1!=nums[i]){
                res.add(i+1);
            }
        }

        return res;
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}

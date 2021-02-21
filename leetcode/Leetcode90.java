package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {
    ArrayList<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        dfs(nums,0);
        return res;
    }

    public void dfs(int[] nums,int index){
        for (int i = index; i < nums.length; i++) {
            if(i>index&&nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(nums,i+1);
            list.remove(list.size()-1);
        }
    }
}

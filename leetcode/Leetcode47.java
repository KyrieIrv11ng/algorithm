package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode47 {
    List<List<Integer>> res;
    List<Integer> list;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length==0){
            return new ArrayList<List<Integer>>();
        }
        this.res = new ArrayList<>();
        this.list = new ArrayList<>();
        this.used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,0);
        return res;
    }

    public void dfs(int[] nums,int index){
        if(index == nums.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]){        //剪枝
                continue;
            }
            if(!used[i]){
                used[i] = true;
                list.add(nums[i]);
                dfs(nums,index+1);
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}

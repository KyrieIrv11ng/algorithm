package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {
    private ArrayList<List<Integer>> res;
    private ArrayList<Integer> list;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(nums,0);
        return res;

    }

    public void dfs(int[] nums,int index){
        for(int i = index;i<nums.length;i++){
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(nums,i+1);
            list.remove(list.size()-1);
        }
    }
}

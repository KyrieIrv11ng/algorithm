package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {
    private ArrayList<List<Integer>> res;
    private ArrayList<Integer> list;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return res;
    }

    public void dfs(int[] candidates,int target,int index){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        //for循环是平级，递归是往下走
        for (int i = index; i < candidates.length; i++) {
            if(target-candidates[i]>=0){
                if(i>index&&candidates[i] == candidates[i-1]){
                    continue;       //剪枝，同一层，当当前的数不是第一个出现且是重复出现的话，
                                    // 就会出现重复元素，就对其进行剪枝
                                    //这样可以避免相同的情况筛选两次（一次原生For循环，一次是递归）
                }
                list.add(candidates[i]);
                dfs(candidates,target-candidates[i],i+1);
                list.remove(list.size()-1);
            }
        }
    }
}

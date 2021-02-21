package leetcode.回溯DFS;

import java.util.*;

public class Leetcode39 {
    List<List<Integer>> res;
    Deque<Integer> de;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.de = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return  res;
    }
    public void dfs(int[] candidates, int target,int start){
        if(target == 0){
            res.add(new ArrayList<>(de));
        }

        for (int i = start; i < candidates.length; i++) {
            int temp = candidates[i];
            if (target-temp<0){    //排序后，如果当前的值减去temp小于0，即后面的都小于0，直接break
                break;
            }
            de.addLast(temp);
            dfs(candidates,target-temp,i); //因为递归下去仍需要遍历重复元素，但是第二轮就可以直接从i++开始遍历
            de.removeLast();
        }
    }
}

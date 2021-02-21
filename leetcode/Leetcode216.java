package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode216 {
    ArrayList<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k,n,1);
        return res;
    }

    public void dfs(int k,int n,int start){
        if(k==0&&n==0){         //当剩余数字等于0且当前和为0，就返回一个组合
            res.add(new ArrayList<>(list));
            return;
        }
        if(k<=0||n-start<0){        //剩余数字小于等于0或者当前数字小于0，直接返回
            return;
        }
        for (int i = start; i <= 9; i++) {
            if(n-i<0){              //剪枝，因为已经排过序了
                continue;
            }
            list.add(i);
            dfs(k-1,n-i,i+1);
            list.remove(list.size()-1);
        }
    }
}

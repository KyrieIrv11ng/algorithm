package leetcode.回溯DFS;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    List<String> res ;
    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        dfs("",n,n);
        return res;
    }

    public void dfs(String path,int left,int right){
        if(left==0&&right==0){
            res.add(path);
        }
        if(left<0){
            return;
        }
        if(left>right){
            return;
        }
        dfs(path+"(",left-1,right);
        dfs(path+")",left,right-1);
    }
}

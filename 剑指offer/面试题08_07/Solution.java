package 剑指offer.面试题08_07;

import 数据结构.数组.Array;

import java.util.ArrayList;

public class Solution {
    private boolean[] visited;
    private StringBuilder sb = new StringBuilder();
    private ArrayList<String> res = new ArrayList<>();
    public String[] permutation(String S) {
        if(S.length()==0){
            return new String[0];
        }
        visited = new boolean[S.length()];
        char[] string = S.toCharArray();
        dfs(string,0);
        String[] ans = new String[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public void dfs(char[] s,int index){
        if(index==s.length){
            res.add(sb.toString());
        }else{
            for (int i = 0; i < s.length; i++) {
                if(!visited[i]){
                    sb.append(s[i]);
                    visited[i] = true;
                    dfs(s,index+1);
                    visited[i] = false;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }
}

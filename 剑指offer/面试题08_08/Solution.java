package 剑指offer.面试题08_08;

import java.util.ArrayList;
import java.util.Arrays;

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
        Arrays.sort(string);
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
                if(i>0&&s[i]==s[i-1]&&!visited[i-1]){//剪枝，前一个没用过时
                    // ，后一个与前一个相同时，那就说明这个排列之前用过了，所以跳过
                    continue;
                }
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

package 剑指offer.面试题38;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    StringBuilder sb;
    ArrayList<String> result;
    boolean[] visited;
    public String[] permutation(String s) {
        this.sb = new StringBuilder();
        this.result = new ArrayList<>();
        this.visited = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(chars,0);
        return result.toArray(new String[0]);
    }
    public void dfs(char[] s,int index){
        if(index == s.length){
            result.add(sb.toString());
        }else{
            for(int i = 0;i < s.length;i++){
                if((i>0&&s[i]==s[i-1]&&!visited[i - 1])||visited[i]){      //如果当前字符和前一个字符相等且前一个,或次字符之前用到过，剪枝
                    continue;
                }
                visited[i]=true;
                sb.append(s[i]);
                dfs(s,index+1);
                sb.deleteCharAt(index);
                visited[i] = false;
            }
        }
    }
}

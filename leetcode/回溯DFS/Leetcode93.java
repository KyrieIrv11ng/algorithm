package leetcode.回溯DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode93 {
    List<String> result;
    Deque<String> path ;
    public List<String> restoreIpAddresses(String s) {
        this.result = new ArrayList<>();
        this.path = new ArrayDeque<>();
        dfs(s,0,0);
        return result;
    }

    public void dfs(String s,int start,int length){
        if(start==s.length()&&length==4){
            result.add(String.join(".",path));
        }
        if(start<s.length()&&length==4){
            return;
        }
        for(int len = 1;len<=3;len++){
            if((start+len-1)>=s.length()){
                return;
            }
            if(s.charAt(start) == '0'&&len!=1){
                return;
            }
            String str = s.substring(start,start+len);
            if(len==3&&Integer.parseInt(str)>255){
                return;
            }
            path.addLast(str);
            dfs(s,start+len,length+1);
            path.removeLast();
        }
    }
}

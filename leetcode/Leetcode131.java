package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode131 {
    List<List<String>> res;
    Deque<String > de;
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        this.de = new ArrayDeque<>();
        dfs(s,0);
        return res;
    }

    public void dfs(String s,int start){
        if(start == s.length()){            //如果start等于s的长度，直接将list添加到result中
            res.add(new ArrayList<>(de));
        }
        for(int i = start;i<s.length();i++){
            if(!isplalindrome(s,start,i)){
                continue;  //注意是continue 如果不符合继续循环下一个i
            }
            de.addLast(s.substring(start,i+1));
            dfs(s,i+1);
            de.removeLast();
        }
    }
    public boolean isplalindrome(String s,int lo,int hi){

        while(lo<hi){
            if(s.charAt(lo)!=s.charAt(hi)){
                return false;
            }else{
                lo++;
                hi--;
            }
        }
        return true;
    }
}

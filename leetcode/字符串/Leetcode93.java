package leetcode.字符串;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode93 {
    List<String> result;
    Deque<String> path ;
    public List<String> restoreIpAddresses(String s) {
        this.result = new ArrayList<>();
        this.path = new ArrayDeque<>();//储存每个段的String
        dfs(s,0,0);
        return result;
    }

    public void dfs(String s,int start,int length){
        if(start==s.length()&&length==4){       //如果start到末尾且ip地址段达到四段
            result.add(String.join(".",path));
        }
        if(start<s.length()&&length==4){        //如果ip地址段达到四段，且数字没有分配完，return
            return;
        }
        for(int len = 1;len<=3;len++){      //每段有四段长度
            if((start+len-1)>=s.length()){      //如果长度大于s的长度，return
                return;
            }
            if(s.charAt(start) == '0'&&len!=1){ //开头为0且个数不为1
                return;
            }
            String str = s.substring(start,start+len);      //符合规定，截取字符串
            if(len==3&&Integer.parseInt(str)>255){      //字符串大于255，return
                return;
            }
            path.addLast(str);          //将字符串添加
            dfs(s,start+len,length+1);
            path.removeLast();          //回溯
        }
    }
}

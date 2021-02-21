package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode784 {
    private ArrayList<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCasePermutation(String S) {
        if(S.length()==0){
            return new ArrayList<>();
        }
        char[] string = S.toCharArray();
        dfs(string,0);
        return res;
    }
    public void dfs(char[] string ,int index){
        if(index==string.length){
            res.add(sb.toString());
            return;
        }
        if(Character.isDigit(string[index])){       //如果是数字，直接加入
            sb.append(string[index]);
            dfs(string,index+1);
            sb.deleteCharAt(sb.length()-1);
        } else if(Character.isLowerCase(string[index])){      //如果是小写字母，先将小写字母加进去，等回溯完再将大写字母加进去
            sb.append(string[index]);
            dfs(string,index+1);
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toUpperCase(string[index]));
            dfs(string,index+1);
            sb.deleteCharAt(sb.length()-1);
        } else{  //如果是大写字母，先将大写字母加进去，等回溯完再将小写字母加进去
            sb.append(string[index]);
            dfs(string,index+1);
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toLowerCase(string[index]));
            dfs(string,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

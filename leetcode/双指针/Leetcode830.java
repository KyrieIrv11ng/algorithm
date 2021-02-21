package leetcode.双指针;

import java.util.ArrayList;
import java.util.List;

public class Leetcode830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        if(s.length()<3){
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        s = s+" ";
        int begain = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)){     //如果前两个数相同，就继续
                continue;
            }else{
                if(i-begain>=2){            //如果不相同，说明没有连续的了
                    list.add(begain);       //查看长度，如果长度大于等于3就满足
                    list.add(i);        //加入
                    res.add(new ArrayList<>(list));
                    list.clear();
                }
                begain = i+1;       //更新起始点
            }
        }
        return res;
    }
}

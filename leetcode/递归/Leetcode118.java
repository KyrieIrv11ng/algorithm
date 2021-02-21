package leetcode.递归;

import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
    //方法1：递归（我的方法）
    List<List<Integer>> res;
    public List<List<Integer>> generate(int numRows) {
        if(numRows <= 0){
            return new ArrayList<>();
        }
        if(numRows == 1){
            res = new ArrayList<>();
            res.add(new ArrayList<>());
            res.get(0).add(1);
            return res;
        }else {
            List<Integer> list = generate(numRows-1).get(numRows -2);
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int i = 0; i < list.size()-1; i++) {
                temp.add(list.get(i)+list.get(i+1));
            }
            temp.add(1);
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
    //方法2：动态规划
    public List<List<Integer>> generate2(int numRows) {
        if(numRows <= 0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for(int i = 1;i< numRows;i++){
            List<Integer> pre = res.get(i-1);
            ArrayList<Integer> temp = new ArrayList();
            temp.add(1);
            for(int j = 0;j<pre.size()-1;j++){
                temp.add(pre.get(j)+ pre.get(j+1));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}

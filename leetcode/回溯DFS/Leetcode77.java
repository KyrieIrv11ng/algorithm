package leetcode.回溯DFS;

import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        if(n<=0||k<=0||k>n){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        helper(n,k,1,result,l,0);
        return  result;
    }

    public void helper(int n,int k,int start,List<List<Integer>> result,List<Integer> l,int index){
        if(k==l.size()){
            result.add(new ArrayList<>(l));
        }else{//还有k = l.size()个空位，所以，[i...n]中至少要有K-C.SIZE（）个元素
            //i最多为n-（k-l.size()）+1
            for (int i = start; i <= n-(k-l.size())+1; i++) {       //剪枝操作，缩小范围，比如n=7 k=5时，从1开始搜索，到5的时候，就可以剪枝了，
                                    // 因为后面剩余的数以及不够组合了，剪枝
                l.add(i);
                helper(n,k,i+1,result,l,index+1);//每次start+1缩小范围
                l.remove(index);//回溯
            }
        }
    }


}

package leetcode.动态规划;

import java.util.ArrayList;
import java.util.List;

public class Leetcode119 {
    //动态规划
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex<0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex+1; i++) {
            res.add(1);
            for(int j = i-1;j>0;j--){
                res.set(j,res.get(j)+res.get(j-1));     //每次往里面加1，再改变里面的数，等于当前数与前一个数的和
            }
        }
        return res;
    }
}

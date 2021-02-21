package leetcode.数学;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        ArrayList<Boolean> res = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = (ans*2 + A[i])%10;        //转化为十进制，模10防止溢出
            if(ans%5==0){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}

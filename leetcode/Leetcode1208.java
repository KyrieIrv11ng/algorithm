package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            maxCost = maxCost - Math.abs(s.charAt(i)-t.charAt(i));
            while(maxCost<0){
                maxCost = maxCost+Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            res = Math.max(i-left+1,res);
        }
        return res;
    }
}

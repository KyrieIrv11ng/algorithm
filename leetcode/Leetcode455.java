package leetcode;

import java.util.Arrays;

public class Leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int bis = 0;
        int res = 0;
        while(child<g.length&&bis<s.length){
            if(g[child]<=s[bis]){
                child++;
                bis++;
                res++;
            }else{
                bis++;
            }
        }
        return res;
    }
}

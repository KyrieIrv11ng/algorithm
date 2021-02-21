package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> m = new HashMap<>();
        int res = 0;
        for (int i : A) {
            for (int j : B) {
                m.put((i+j),m.getOrDefault((i+j),0)+1);
            }
        }

        for (int i : C) {
            for (int j : D) {
                int temp = (i+j)*(-1);
                if(m.containsKey(temp)){
                    res = res+m.get(temp);
                }
            }
        }
        return res;
    }
}

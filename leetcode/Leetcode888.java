package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int value : A) {
            sumA = sumA + value;
        }
        for (int value : B) {
            sumB = sumB + value;
        }
        int dlta = (sumA - sumB)/2;
        Set<Integer> s = new HashSet<>();
        for (int i : A) {
            s.add(i);
        }
        int[] res = new int[2];
        for (int i : B) {
            int tmp = i+dlta;
            if(s.contains(tmp)){
                res[0] = tmp;
                res[1] = i;
            }
        }
        return res;
    }
}

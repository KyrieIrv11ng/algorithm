package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int num;
        int carry = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            num = K % 10 + A[i] + carry;
            carry = num / 10;
            num = num % 10;
            res.add(num);
            K = K / 10;
        }
        while (K > 0) {
            num = K % 10+carry;
            carry = num/10;
            num = num % 10;
            res.add(num);
            K = K / 10;
        }
        if (carry == 1) {
            res.add(1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            ans.add(res.get(i));
        }
        return ans;
    }
}

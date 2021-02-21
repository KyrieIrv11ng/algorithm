package 剑指offer.面试题17;

public class Solution {
    public int[] printNumbers(int n) {
        int start = 1;
        int[] res = new int[(int) Math.pow(10,n)-1];
        for (int i = 0; i < res.length; i++) {
            res[i] = start++;
        }
        return res;
    }
}

package 剑指offer.面试题66;

public class Solution {
    public int[] constructArr(int[] a) {
        //动态规划，计算每个数左边的乘积和右边的乘积
        if(a.length==0){
            return new int[0];
        }
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = 1;
        right[a.length-1] = 1;
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i-1]*a[i-1];
        }

        for (int i = a.length-2; i >= 0; i--) {
            right[i] = right[i+1]*a[i+1];
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = left[i]*right[i];
        }
        return a;
    }
}

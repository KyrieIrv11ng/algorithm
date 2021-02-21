package leetcode;

public class Leetcode1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int res = 0;
        int zeroCount = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]==0){
                zeroCount++;
            }
            while(zeroCount>K){
                if(A[left]==0){
                    left++;
                    zeroCount--;
                }
            }
            res = Math.max(res,i-left+1);
        }
        return res;
    }
}

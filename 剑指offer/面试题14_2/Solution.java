package 剑指offer.面试题14_2;

public class Solution {
    public int cuttingRope(int n) {
        if(n<3){
            return 1;
        }
        if(n==3){
            return 2;
        }
        long res = 1;
        while(n>4){
            res = res*3;
            res = res % 1000000007;
            n = n - 3;
        }
        return (int)(res * n)%1000000007;
    }
}

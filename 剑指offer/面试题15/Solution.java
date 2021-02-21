package 剑指offer.面试题15;

public class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        while(n!=0){
            ans++;
            n=n&(n-1);
        }
        return ans;
    }
}

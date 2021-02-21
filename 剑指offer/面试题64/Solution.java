package 剑指offer.面试题64;

public class Solution {
    public int sumNums(int n) {
        if(n==1){
            return 1;
        }else return sumNums(n-1)+n;

    }
}

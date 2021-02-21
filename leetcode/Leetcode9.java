package leetcode;

public class Leetcode9 {
    //将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等。
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        while(x>right){
            right = right*10 + x%10;
            x = x/10;
        }
        return right==x || x==right/10;
    }
}

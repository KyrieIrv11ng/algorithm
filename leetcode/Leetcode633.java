package leetcode;

public class Leetcode633 {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while(left<=right){
            if(left*left+right*right==c){
                return true;
            }else if(left*left+right*right>c){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }
}

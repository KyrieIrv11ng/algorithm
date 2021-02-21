package leetcode.数学;

public class Leetcode263 {
    public boolean isUgly(int num) {
        if(num <1) return false;
        while(num%5 == 0){
            num = num/5;
        }
        while(num%3 == 0){
            num = num/3;
        }
        while(num%2 == 0){
            num = num/2;
        }
        if(num == 1){
            return true;
        }else return false;
    }
}

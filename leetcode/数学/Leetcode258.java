package leetcode.数学;

public class Leetcode258 {
    public int addDigits(int num) {
        while(num>9){
            num = add(num);
        }
        return num;
    }

    public int add(int num){
        int ans = 0;
        while(num!=0){
            ans = ans + num%10;
            num = num/10;
        }
        return ans;
    }
}

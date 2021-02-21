package 剑指offer.面试题16;

public class Solution {
    public double myPow(double x, int n) {
        long b = n;
        double res = 1.0;
        if(b<0){        //如果b是负数，就让b变符号，x变倒数
            b = -b;
            x = 1/x;
        }
        while(b>0){
            if((b&1)==1){       //若n为10  二进制即为 1010  2^10 表示为 2^8*2^2  即为每一个为1的进制的次方相乘
                res = res * x;      //如果二进制当前位数为1的话 就乘他
            }
            x = x*x;        //保持每一位的次方对应的次方数
            b = b>>1;       //次方二进制数右移
        }
        return res;
    }
}

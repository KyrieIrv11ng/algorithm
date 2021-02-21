package leetcode.数学;

public class Leetcode50 {
    public double myPow(double x, int n) {
        long b = n;
        double res = 1.0;
        if(b<0){
            b = -b;
            x = 1/x;
        }
        while(b>0){
            if((b&1)==1){
                res = res *x;
            }
            x = x * x;
            b = b>>1;
        }
        return res;
    }
}

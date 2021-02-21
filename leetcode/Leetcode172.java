package leetcode;

public class Leetcode172 {
    //找五的个数  例如25！=25*24*23*22*21*20*19*18*17*16*15*14*13*12*11*10*9*8*7*6*5*4*3*2*1
    public int trailingZeroes(int n) {
        int count = 0;
        while(n>=5){
            count = count+ n/5;
            n = n/5;
        }
        return count;
    }
}

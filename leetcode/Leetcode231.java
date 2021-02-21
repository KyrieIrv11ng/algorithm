package leetcode;

public class Leetcode231 {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        while(n%2==0){
            n = n/2;
        }
        return n==1;
    }
    //其他题解，位运算
    /*解题思路：
    若 n = 2^xn=2
    x
    且 xx 为自然数（即 nn 为 22 的幂），则一定满足以下条件：
    恒有 n & (n - 1) == 0，这是因为：
    nn 二进制最高位为 11，其余所有位为 00；
    n - 1n−1 二进制最高位为 00，其余所有位为 11；
    一定满足 n > 0。
    因此，通过 n > 0 且 n & (n - 1) == 0 即可判定是否满足 n = 2^xn=2
    x
 。
         2^x	n	n - 1	n & (n - 1)
            2^02
            0
            00010001	00000000	(0001) & (0000) == 0
            2^12
            1
            00100010	00010001	(0010) & (0001) == 0
            2^22
            2
            01000100	00110011	(0100) & (0011) == 0
            2^32
            3
            10001000	01110111	(1000) & (0111) == 0*/

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

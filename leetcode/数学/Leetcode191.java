package leetcode.数学;

public class Leetcode191 {
    public int hammingWeight(int n) {
        int ans = 0;
        while(n!=0){
            ans++;
            n = n&(n-1);    //每次都能把最右边的1给消除
                            //如 0010010和0010001进行&操作会得到 0010000，消除最右边的1
                            //0010000和0001000进行&操作会得到000000，消除最右边的1，同时跳出循环
        }
        return ans;
    }
}

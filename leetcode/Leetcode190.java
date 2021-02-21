package leetcode;

public class Leetcode190 {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            int temp = (n >> i) & 1;//取每一位的位数
            ans = ans + (temp<<(31-i));       //翻转 左移相应单位
        }
        return ans;
    }
}

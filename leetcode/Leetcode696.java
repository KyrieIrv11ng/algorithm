package leetcode;

public class Leetcode696 {
    public int countBinarySubstrings(String s) {
        //先统计连续的0和1分别有多少个，如：111100011000，
        // 得到4323；在4323中的任意相邻两个数字，取小的一个加起来，就是3+2+2 = 7.
        int preLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }

            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }
}

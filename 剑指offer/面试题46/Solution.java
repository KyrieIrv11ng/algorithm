package 剑指offer.面试题46;

public class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1;//第二个，字符串为一个的时候
        int b = 1;//第一个，字符串为空的时候
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i-2,i);        //截取当前字符串最后两个
            int c;
            if(Integer.parseInt(tmp)>=10&&Integer.parseInt(tmp)<=25){   //如果最后两个数字可以转化为
                                            // 字符串的话，f(n) = f(n-2)+f(n-1)有两种方案，一种转化最后两个，一种转化最后一个
                c = a+b;
            }else{                      //如果最后两个数字不可以转化为字符串的话，f(n)=f(n-1)，只能转化最后一个
                c = a;
            }
            b = a;
            a = c;
        }
        return a;
    }
}

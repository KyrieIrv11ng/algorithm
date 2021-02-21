package leetcode;

public class Leetcode202 {
    //双指针解决循环问题，成环问题
    public boolean isHappy(int n) {
        // 利用快慢指针思想, 慢指针每次做一次转换, 快指针每次做两次转换
        // 如果出现无限循环, 那么快慢指针一定相遇
        int slow = getPingfang(n);
        int fast = getPingfang(slow);
        while(slow!=fast){
            slow = getPingfang(slow);
            fast = getPingfang(getPingfang(fast));
        }
        return slow==1;
    }

    public int getPingfang(int n){
        int res = 0;
        while(n!=0){
            int remin = n%10;
            res = res+remin*remin;
            n = n/10;
        }
        return res;
    }
}

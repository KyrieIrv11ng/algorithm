package leetcode.队列和栈;

import java.util.Stack;

public class Leetcode402 {
    //最小栈
    public String removeKdigits(String num, int k) {
        if(num.length()==k){
            return "0";
        }
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if(s.isEmpty()){
                if(num.charAt(i)=='0'){
                   continue;
                }
                s.push(num.charAt(i));
            }else if(num.charAt(i)>=s.peek()){
                s.push(num.charAt(i));
            }else{
                while(!s.isEmpty()&&k>0&&num.charAt(i)<s.peek()){
                    s.pop();
                    k--;
                }
                if(s.isEmpty()&&num.charAt(i)=='0') {
                    continue;
                }
                s.push(num.charAt(i));
            }
        }
        while(k>0&&!s.isEmpty()){
            s.pop();
            k--;
        }
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.reverse().toString().equals("")?"0":sb.toString();
    }
}

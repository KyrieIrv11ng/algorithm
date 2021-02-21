package leetcode;

import java.util.Stack;

public class Leetcode316 {
    public static String removeDuplicateLetters(String s) {
        int[] val = new int[26];
        for (int i = 0; i < s.length(); i++) {
            val[s.charAt(i)-'a']++;
        }
        Stack<Character> res = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(res.contains(s.charAt(i))){
                val[s.charAt(i)-'a']--;
                continue;
            }
            while(!res.isEmpty()&&s.charAt(i)<res.peek()&&val[res.peek()-'a']>0){
                res.pop();
            }
            res.push(s.charAt(i));
            val[s.charAt(i)-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while(!res.isEmpty()){
            sb.append(res.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}

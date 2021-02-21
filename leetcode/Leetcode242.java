package leetcode;

import java.util.Arrays;

public class Leetcode242 {
    //我的方法
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] help = new int[26];
        for (int i = 0; i < s.length(); i++) {
            help[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            help[t.charAt(i)-'a']--;
            if(help[t.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }
    //其他方法
    public boolean isAnagram1(String s, String t) {
        char[] cs1 = s.toCharArray();
        char[] cs2 = t.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        return new String(cs1).equals(new String(cs2));
    }
}

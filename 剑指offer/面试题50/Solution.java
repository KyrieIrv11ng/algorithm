package 剑指offer.面试题50;

public class Solution {
    public char firstUniqChar(String s) {
        if(s.length()==0||s==null){
            return ' ';
        }
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)-'a']++;
        }
        for (int j = 0; j < s.length(); j++) {
            if(a[s.charAt(j)-'a']==1){
                return s.charAt(j);
            }
        }
        return ' ';
    }
}

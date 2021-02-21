package leetcode;

public class Leetcode387 {
    public int firstUniqChar(String s) {
        int[] help = new int[26];
        for (int i = 0; i < s.length(); i++) {
            help[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(help[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}

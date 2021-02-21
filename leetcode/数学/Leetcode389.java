package leetcode.数学;

public class Leetcode389 {
    public char findTheDifference(String s, String t) {
        if(s==null||s.length()==0){
            return t.charAt(0);
        }
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            c[t.charAt(i)-'a']--;
            if(c[t.charAt(i)-'a']==-1){
                return t.charAt(i);
            }
        }
        return 'a';
    }

    //方法2：求和
    public char findTheDifference1(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    //方法3：位运算
    public char findTheDifference3(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }


}

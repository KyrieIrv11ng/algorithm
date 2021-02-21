package 剑指offer.面试题5;

public class Solution {
    public String replaceSpace(String s) {
        int spaceNum = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i)==' '){
                spaceNum++;
            }
        }
        char[] c = new char[s.length() + spaceNum*2];
        int i = s.length()-1;
        int j = c.length - 1;
        while(i >= 0 && j >= 0){
            if(s.charAt(i)==' '){
                c[j--]='0';
                c[j--]='2';
                c[j--]='%';
            }else{
                c[j--]=s.charAt(i);
            }
            i--;
        }
        String s1 = new String(c);
        return s1;
    }
}

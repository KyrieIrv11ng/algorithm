package leetcode.双指针;

import java.util.List;

public class Leetcode524 {
    public String findLongestWord(String s, List<String> d) {
        String longestString = "";
        for (String s1 : d) {
            if(longestString.length()>s1.length()||(s1.length()==longestString.length()&&longestString.compareTo(s1)<0)){
                continue;
            }
            if(isSubstr(s,s1)){
                longestString = s1;
            }
        }
        return longestString;
    }


    public boolean isSubstr(String s1,String s2){
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(index<s2.length()&&s1.charAt(i)==s2.charAt(index)){
                index++;
            }
        }
        if(index == s2.length()){
            return true;
        }
        return false;
    }
}

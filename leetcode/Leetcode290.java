package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode290 {
    public static boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split("[^a-zA-Z]+");
        System.out.println(Arrays.toString(s1));
        if(pattern.length()!=s1.length) return false;
        Map<Character,String> m = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(!m.containsKey(pattern.charAt(i))){
                if(m.containsValue(s1[i])){
                    return false;
                }
                m.put(pattern.charAt(i),s1[i]);
            }else{
                if(!m.get(pattern.charAt(i)).equals(s1[i])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        System.out.println(wordPattern(pattern,str));
    }
}

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode205 {
    //方法2 我的方法
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Character> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!m.containsKey(s.charAt(i))){
                if(m.containsValue(t.charAt(i))){
                    return false;
                }
                m.put(s.charAt(i),t.charAt(i));
            }else{
                if(m.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

    //方法2
    public static boolean isIsomorphic1(String s, String t) {
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            if(map1.containsKey(s.charAt(i))){
                if(map1.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else if(map2.containsKey(t.charAt(i))){
                if(map2.get(t.charAt(i))!=s.charAt(i)){
                    return false;
                }
            } else{
                map1.put(s.charAt(i),t.charAt(i));
                map2.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }

    //方法3   用数字做映射
    /*将第一个出现的字母映射成 1，第二个出现的字母映射成 2

    对于 egg
    e -> 1
    g -> 2
    也就是将 egg 的 e 换成 1, g 换成 2, 就变成了 122

    对于 add
    a -> 1
    d -> 2
    也就是将 add 的 a 换成 1, d 换成 2, 就变成了 122

    egg -> 122, add -> 122
    都变成了 122，所以两个字符串异构。*/
    public boolean isIsomorphic2(String s, String t) {
        return isIsomorphicHelper(s).equals(isIsomorphicHelper(t));
    }

    private String isIsomorphicHelper(String s) {
        int[] map = new int[128];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //当前字母第一次出现,赋值
            if (map[c] == 0) {
                map[c] = count;
                count++;
            }
            sb.append(map[c]);
        }
        return sb.toString();
    }
    //方法4
  /*  对 abaddee 和 cdbccff

    a b a d d e e
    c d b c c f f
^

    当前
    a -> 0
    c -> 0

    修改映射
    a -> 1
    c -> 1

    a b a d d e e
    c d b c c f f
  ^

    当前
    b -> 0
    d -> 0

    修改映射
    b -> 2
    d -> 2


    a b a d d e e
    c d b c c f f
    ^
    当前
    a -> 1 (之前被修改过)
    b -> 0

    出现不一致，所以两个字符串不异构*/

    public boolean isIsomorphic3(String s, String t) {
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //当前的映射值是否相同
            if (mapS[c1] != mapT[c2]) {
                return false;
            } else {
                //是否已经修改过，修改过就不需要再处理
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }
}

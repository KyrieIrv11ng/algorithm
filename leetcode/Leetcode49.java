package leetcode;

import java.util.*;

public class Leetcode49 {
    //对str排序，用排好序的str作为key，如果存在键值，就存入，不存在就生成新的list
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> m = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = m.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            m.put(key,list);
        }
        return new ArrayList<List<String>>(m.values());
    }
}

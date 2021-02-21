package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode451 {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b) -> (map.get(b)-map.get(a)));
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(Character character:map.keySet()){
            pq.offer(character);
        }
        while(!pq.isEmpty()){
            char tmp = pq.poll();
            int k = map.get(tmp);
            for (int i = 0; i < k; i++) {
                sb.append(tmp);
            }
        }
        return sb.toString();
    }
}

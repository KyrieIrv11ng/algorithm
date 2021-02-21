package leetcode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        Map<Character,Integer> m = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            while(m.containsKey(s.charAt(i))){      //移除左边不符合的元素，调整窗口
                m.remove(s.charAt(left));
                left++;
            }
            m.put(s.charAt(i),i);
            ans = Math.max(ans,i-left+1);
        }
        return ans;
    }
}

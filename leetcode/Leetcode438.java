package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode438 {
    //类似76题
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int[] need = new int[128];
        int[] window = new int[128];
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            window[c]++;
            if(need[c]>0&&window[c]<=need[c]){
                count++;
            }
            while(count==p.length()){
                System.out.println(left);
                char ch = s.charAt(left);
                if(need[ch]>0&&window[ch]==need[ch]){
                    count--;
                }
                if((i-left+1)==p.length()){     //只不过把这里条件改为(i-left+1)==p.length()  数组长度一样才输出
                    res.add(left);
                }
                window[ch]--;
                left++;
            }
        }
        return res;
    }
}

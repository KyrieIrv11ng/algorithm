package leetcode.滑动窗口;

public class Leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] window = new int[26];
        int[] has = new int[26];
        int len = s1.length();
        int count = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s1.length(); i++) {
            char tmp = s1.charAt(i);
            has[tmp-'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if(window[c-'a']<has[c-'a']){
                count++;
            }
            window[c-'a']++;
            System.out.println(i);
            System.out.println(left);
            while(count==len){
                char c1 = s2.charAt(left);
                if(has[c1-'a']!=0&&window[c1-'a']==has[c1-'a']){
                    count--;
                    min = Math.min(min,i-left+1);
                }
                window[c1-'a']--;
                left++;
            }
        }
        System.out.println(len);
        System.out.println(min);
        return len == min;
    }
}

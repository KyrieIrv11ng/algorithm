package leetcode;

public class Leetcode76 {
    public String minWindow(String s, String t) {
        if(s==null||t==null||s.length()==0||t.length()==0||s.length()<t.length()){
            return "";
        }
        int[] need = new int[128];
        int[] window = new int[128];
        int min = s.length()+1;
        String ans ="";
        int left = 0;
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            window[tmp]++;
            if(need[tmp]>0&&window[tmp]<=need[tmp]){
                count++;            //每次记录need和window里面相同字符的个数
            }
            while(count==t.length()){       //当window里面包含所有need里面的字符时
                char ch = s.charAt(left);
                if(need[ch]>0&&need[ch]==window[ch]){   //当达到字符等于need中字符时 left再右移一位
                    count--;
                }
                if((i-left+1)<min){
                    min = Math.min(min,i-left+1);
                    ans = s.substring(left,i+1);
                }
                window[ch]--;
                left++;
            }

        }
        return ans;
    }
}

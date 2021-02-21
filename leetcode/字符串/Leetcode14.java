package leetcode.字符串;

public class Leetcode14 {
    //用第一个字符串来当ans，然后与后面的字符串前缀作对比，返回最长匹配串
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while(j<strs[i].length()&&j<ans.length()) {
                if (strs[i].charAt(j)!=ans.charAt(j)){
                    break;
                }else{
                    j++;
                }
            }
            ans = ans.substring(0,j);
            if(ans.equals("")){
                return ans;
            }

        }

        return ans;
    }
}

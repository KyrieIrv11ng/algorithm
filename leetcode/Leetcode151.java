package leetcode;

public class Leetcode151 {

    public String reverseWords(String s) {
        s = s.trim();//去掉两侧空格
        StringBuilder sb = new StringBuilder();
        int end = s.length()-1;
        int start = end;
        while(start>=0){
            while(start>=0 && s.charAt(start)!=' '){
                start--;//如果不为空格就一直减
            }
            sb.append(s.substring(start+1,end+1)+' '); //添加注意substring用法，substring最后一位是截取到数字的后一位
            while(start>=0 && s.charAt(start)==' '){
                start--;        //等于空格就一直减去空格
            }
            end = start;
        }
        return sb.toString().trim();
    }

}

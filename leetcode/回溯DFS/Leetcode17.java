package leetcode.回溯DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode17 {
    public static List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList();
        }
        List<String> result = new ArrayList();
        StringBuilder sb = new StringBuilder();
        Map<Character,String> m = new HashMap<>();
        m.put('2',"abc");
        m.put('3',"def");
        m.put('4',"ghi");
        m.put('5',"jkl");
        m.put('6',"mno");
        m.put('7',"pqrs");
        m.put('8',"tuv");
        m.put('9',"wxyz");
        helper(m,result,digits,sb,0);
        return result;
    }

    public static void helper(Map<Character,String> m,List<String> result,String digits,StringBuilder sb,int index){
        System.out.println(index+":"+sb.toString());
        if(index==digits.length()){
            System.out.println("get:"+sb.toString()+" return");
            result.add(sb.toString());
        }else{
            char temp = digits.charAt(index);
            String letters = m.get(temp);
            int digitslength = letters.length();
            for (int i = 0; i < digitslength; i++) {
                char c = letters.charAt(i);
                System.out.println("digits["+index+"]="+temp+",use "+ c);
                sb.append(c);
                helper(m,result,digits,sb,index+1);
                sb.deleteCharAt(index);
                System.out.println("after reback:"+sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        String s = "23";
        letterCombinations(s);
    }
}

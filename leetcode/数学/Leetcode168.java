package leetcode.数学;

public class Leetcode168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            n--;//原来A~Z都是1~26 如果要搞为26进制的话，每次位数上减一就成了26进制
            int reminder = n%26;
            sb.append((char)('A'+reminder));
            n = n/26;
        }
        return sb.reverse().toString();
    }
}

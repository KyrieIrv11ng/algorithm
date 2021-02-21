package leetcode.二分;

public class Leetcode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0 , r = letters.length - 1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(target>=letters[m]){
                l = m+1;
            }else {
                r = m-1;
            }
        }
        return l < letters.length ? letters[l] : letters[0];
    }
}

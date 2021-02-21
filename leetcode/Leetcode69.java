package leetcode;

public class Leetcode69 {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int mid = 0;
        while(low<=high){
            mid =low + (high-low)/2;
            if((long)mid*mid==x){
                return mid;
            }else if((long)mid*mid<x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return mid*mid>x?mid-1:mid;
    }
}

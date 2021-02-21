package leetcode;

public class Leetcode204 {
    public int countPrimes(int n) {
        int count = 0;
        for(int i = 2;i<n;i++){
            if(isPrimes(i)){
                count++;
            }
        }
        return count;
    }

    public boolean isPrimes(int n){
        for(int i = 2;i*i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}

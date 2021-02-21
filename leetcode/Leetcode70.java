package leetcode;

public class Leetcode70 {
    //动态规划
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int[] arr = new int[n+1];
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        for(int i = 3;i<arr.length;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[arr.length-1];
    }
    //迭代
    public int climbStairs1(int n){
        if(n<3){
            return n;
        }
        int num1 = 1;
        int num2 = 2;
        int res = 0;
        for(int i = 3;i<n+1;i++){
           res = num1+num2;
           num1 = num2;
           num2 = res;
        }
        return res;
    }
}

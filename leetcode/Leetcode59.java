package leetcode;


public class Leetcode59 {
    public int[][] generateMatrix(int n) {
        if(n==0){
            return null;
        }
        int[][] res = new int[n][n];
        int num = 1;        //从第一个数开始
        int target = n*n;
        int left = 0;
        int right = n-1;
        int top = 0;
        int button = n-1;
        while(num<=target){
            for(int i = left;i<=right;i++){
                res[top][i] = num++;
            }               //填第一行
            top++;
            for(int i = top;i<=button;i++){
                res[i][right] = num++;
            }
            right--;
            for(int i = right;i>=left;i--){
                res[button][i] = num++;
            }
            button--;
            for(int i = button;i>=top;i--){
                res[i][left] = num++;
            }
            left++;
        }
        return res;
    }
}

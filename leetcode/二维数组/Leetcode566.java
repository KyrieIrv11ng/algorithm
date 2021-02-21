package leetcode.二维数组;

public class Leetcode566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = nums[0].length;
        int count = 0;
        if(rows*cols!=r*c){
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[count/cols][count%cols];
                count++;
            }
        }
        return res;
    }
}

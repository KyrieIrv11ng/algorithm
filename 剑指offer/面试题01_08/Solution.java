package 剑指offer.面试题01_08;



public class Solution {
    //我的方法
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0){
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] row0 = new boolean[rows];
        boolean[] col0 = new boolean[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j]==0){
                    row0[i] = true;
                    col0[j] = true;
                }
            }
        }
        for (int i = 0; i < row0.length; i++) {
            if(row0[i] == true){
                for(int j = 0;j<cols;j++){
                    matrix[i][j] = 0;
                }
            }else continue;
        }
        for (int i = 0; i < col0.length; i++) {
            if(col0[i] == true){
                for(int j = 0;j<rows;j++){
                    matrix[j][i] = 0;
                }
            }else continue;
        }
    }
}

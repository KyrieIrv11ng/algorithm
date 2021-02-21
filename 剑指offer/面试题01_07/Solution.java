package 剑指offer.面试题01_07;

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length==0||(matrix.length == 1&&matrix[0].length==1)){
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0;i<rows/2;i++){            //上下翻转
            for(int j = 0;j<cols;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[rows-i-1][j];
                matrix[rows-i-1][j] = temp;
            }
        }

        for(int i = 0;i<rows;i++){              //转置
            for(int j = i+1;j<cols;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

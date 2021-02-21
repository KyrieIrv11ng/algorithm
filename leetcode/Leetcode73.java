package leetcode;

public class Leetcode73 {
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return;
        }
        boolean isbiaoji = false;
        if(matrix[0][0]==0) isbiaoji = true;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            if(matrix[i][0]==0){
                for (int j = 0; j < cols; j++) {
                    matrix[i][j]=0;
                }
            }
        }

        for (int i = 1; i < cols; i++) {
            if(matrix[0][i]==0){
                for (int j = 0; j < rows; j++) {
                    matrix[j][i]=0;
                }
            }
        }


        for (int i = 0; i < rows; i++) {
            if(matrix[i][0]==0){
                for (int j = 0; j < rows; j++){
                    matrix[j][0]=0;
                }
                break;
            }
        }
        for (int i = 0; i < cols; i++) {
            if(matrix[0][i]==0){
                for (int j = 0; j < rows; j++){
                    matrix[0][j]=0;
                }
                break;
            }
        }
    }
}

package leetcode;

public class Leetcode832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols/2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][cols-j];
                A[i][cols-j] = tmp;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(A[i][j]==0){
                    A[i][j]=1;
                }else if(A[i][j]==1){
                    A[i][j]=0;
                }
            }
        }
        return A;
    }
}

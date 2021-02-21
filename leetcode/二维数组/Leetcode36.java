package leetcode.二维数组;

public class Leetcode36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] cols = new boolean[9][9];
        boolean[][] rows = new boolean[9][9];
        boolean[][] boards = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    int num = board[i][j] - '1';
                    int boardIndex = i/3*3+j/3;
                    if(cols[j][num]||rows[i][num]||boards[boardIndex][num]){
                        return false;
                    }else{
                        cols[j][num] = true;
                        rows[i][num] = true;
                        boards[boardIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}

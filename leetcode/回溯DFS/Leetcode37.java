package leetcode.回溯DFS;

public class Leetcode37 {
    boolean[][] cols = new boolean[9][9];
    boolean[][] rows = new boolean[9][9];
    boolean[][] boards = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {       //看哪个位置上有就填充
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    int num = board[i][j] - '1';
                    int boardIndex = i/3*3+j/3;
                    cols[j][num] = true;
                    rows[i][num] = true;
                    boards[boardIndex][num] = true;
                }
            }
        }
        dfs(board,0,0);
    }
    public boolean dfs(char[][] board,int i,int j){
        if(j == board[0].length){
            j = 0;          //看边界值，如果j == board[0].length，另起一行
            i++;
            if(i == board.length){      //看边界值，如果i == board.length，就填充成功
                return true;
            }
        }
        if(board[i][j]=='.'){       //如果当前为.就填充
            for (int k = 0; k < 9; k++) {       //从1-9挨个填充
                int boardIndex = i/3*3+j/3;
                if(!cols[j][k]&&!rows[i][k]&&!boards[boardIndex][k]){   //如果此位置上符合规定
                    board[i][j] = (char) ('1' + k);     //填充
                    cols[j][k] = true;              //状态致为true
                    rows[i][k] = true;
                    boards[boardIndex][k] = true;
                    if(dfs(board,i,j+1)){       //递归，如果成功，返回true，填下一个
                        return true;
                    }
                    cols[j][k] = false;             //填完后回溯
                    rows[i][k] = false;
                    boards[boardIndex][k] = false;
                    board[i][j] = '.';
                }
            }
        }else return dfs(board,i,j+1);      //不为.的话 递归下一个
        return false;
    }
}

package leetcode.回溯DFS;

public class Leetcode130 {
    int[][] towaeds = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int rows;
    int cols;
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0){
            return;
        }
        this.rows = board.length;
        this.cols = board[0].length;
        //把边界的O都置为1
        for (int i = 0; i < rows; i++) {
            dfs(board,i,0);
            dfs(board,i,cols-1);
        }//左右边界
        for (int i = 0; i < cols; i++) {
            dfs(board,0,i);
            dfs(board,rows-1,i);
        }//上下边界


        //将1的转化为O 将O转化为X
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j]=='1'){
                    board[i][j] = 'O';
                }else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board,int x,int y){
        if(!isArea(x,y)||board[x][y]!='O'){
            return;
        }
        board[x][y] = '1';
        for (int i = 0; i < 4; i++) {
            int newX = x + towaeds[i][0];
            int newY = y + towaeds[i][1];
                dfs(board,newX,newY);
        }

    }

    public boolean isArea(int x,int y){
        if(x>=0&&x<rows&&y>=0&&y<cols){
            return true;
        }else{
            return false;
        }
    }
}

package 剑指offer.面试题12;

public class Solution {
    int[][] toward = {{0,-1},{1,0},{0,1},{-1,0}};
    boolean[][] visited;
    int rows;
    int cols;
    public boolean exist(char[][] board, String word) {
        if(board.length==0||board[0].length==0||word.length()==0){
            return false;
        }
        this.rows = board.length;
        this.cols = board[0].length;
        this.visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word,int startx,int starty,int index){
        if(index==word.length()-1){
            return word.charAt(index)==board[startx][starty];
        }
        if(word.charAt(index)==board[startx][starty]){
            visited[startx][starty] = true;
            for (int i = 0; i < 4; i++) {
                int newx = startx+toward[i][0];
                int newy = starty+toward[i][1];
                if(isArea(newx,newy)&&!visited[newx][newy]){
                    if(dfs(board,word,newx,newy,index+1)){
                        return true;
                    }
                }
            }
            visited[startx][starty] = false;
        }
        return false;
    }
    public boolean isArea(int x,int y){
        if(x>=0&&x<rows&&y>=0&&y<cols){
            return true;
        }else return false;
    }
}

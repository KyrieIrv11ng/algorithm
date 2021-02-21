package leetcode.回溯DFS;

public class Leetcode200 {
    int rows;
    int cols;
    int ans;
    boolean isvisited[][];
    int[][] toward = {{0,-1},{1,0},{0,1},{-1,0}};
    public int numIslands(char[][] grid) {
        this.ans = 0;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.isvisited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!isvisited[i][j]&&grid[i][j]=='1'){
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;

    }

    public void dfs(char[][] grid,int startx,int starty){
        isvisited[startx][starty] = true;
        for (int i = 0; i < 4; i++) {
            int newx = startx + toward[i][0];
            int newy = starty + toward[i][1];
            if(isArea(newx,newy)&&!isvisited[newx][newy]&&grid[newx][newy]=='1'){
                dfs(grid,newx,newy);
            }
        }
    }
    public boolean isArea(int x,int y){
        if(x>=0&&x<rows&&y>=0&&y<cols){
            return true;
        }else return false;
    }
}

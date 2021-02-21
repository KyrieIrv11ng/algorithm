package leetcode.二维数组;

public class Leetcode463 {
    //我的答案，类似小学算周长的方法
    public int islandPerimeter(int[][] grid) {
        if(grid.length==0||grid[0].length==0){
            return 0;
        }
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[] rownum = new boolean[rows];//存横坐标右边
        boolean[] colnum = new boolean[cols];//存纵坐标
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j]==1){
                    rownum[i]=true;
                    colnum[j]=true;
                }
                if(i>0){
                    if(grid[i][j]==0&&grid[i-1][j]==1){
                        int temp = i;
                        while(temp<rows){       //如果没有填充的话，且之前有一个填充的，就一直找看
                                                // 看是否有填充的，有就加二
                            if(grid[temp][j]!=1){
                                temp++;
                            }else{
                                result = result+2;
                                break;
                            }
                        }
                    }
                }
                if(j>0){
                    if(grid[i][j]==0&&grid[i][j-1]==1){
                        int temp = j;
                        while(temp<cols){
                            if(grid[i][temp]!=1){
                                temp++;
                            }else{
                                result = result+2;
                                break;
                            }
                        }
                    }

                }
            }
        }
        System.out.println(result);
        for (int i = 0; i < rownum.length; i++) {
            if(rownum[i]==true){
                result = result+2;
            }
        }
        for (int i = 0; i < colnum.length; i++) {
            if(colnum[i]==true){
                result = result+2;
            }
        }
        System.out.println(result);


        return result;
    }

    //dfs算法
    public int islandPerimeter1(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    int dfs(int[][] grid, int r, int c) {
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

}

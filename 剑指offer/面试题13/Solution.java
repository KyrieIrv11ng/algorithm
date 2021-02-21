package 剑指offer.面试题13;

public class Solution {
    boolean[][] visited ;
    int ans;
    int[][] towaed = {{0,-1},{1,0},{0,1},{-1,0}};
    public int movingCount(int m, int n, int k) {
        this.visited = new boolean[m][n];
        this.ans = 0;
        dfs(m,n,k,0,0);
        return ans;
    }

    public void dfs(int m, int n, int k,int startx,int starty){
        ans++;
        visited[startx][starty]=true;
        for (int i = 0; i < 4; i++) {
            int newx = startx+towaed[i][0];
            int newy = starty+towaed[i][1];
            if (isArea(newx,newy,m,n)&&!visited[newx][newy]&&(newx/10+newx%10+newy/10+newy%10)<=k){
                dfs(m,n,k,newx,newy);
            }
        }
    }

    public boolean isArea(int x,int y,int m,int n){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}

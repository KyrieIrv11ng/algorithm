package leetcode.回溯DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode547 {
    //回溯法，DFS
    int res = 0;
    boolean[] visited;
    int rows;
    int cols;
    public int findCircleNum(int[][] isConnected) {
        this.rows = isConnected.length;
        this.cols = isConnected[0].length;
        visited = new boolean[rows];
        for (int i = 0; i < rows; i++) {
            if(!visited[i]){
                dfs(isConnected,i);
                res++;
            }
        }
        return res;

    }
    public void dfs(int[][] isConnected,int toward){
        visited[toward] = true;
        for (int i = 0; i < cols; i++) {
            if(!visited[i]&&isConnected[toward][i]==1){
                dfs(isConnected,i);
            }
        }
    }
    //BSF方法，利用Queue
    public int findCircleNum2(int[][] isConnected){
        this.rows = isConnected.length;
        this.cols = isConnected[0].length;
        visited = new boolean[rows];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            if(!visited[i]){
                visited[i]=true;
                q.offer(i);
                res++;
                while(!q.isEmpty()){
                    int pop = q.poll();
                    for (int j = 0; j < cols; j++) {
                        if(!visited[j]&&isConnected[pop][j]==1){
                            visited[j] = true;
                            q.offer(j);
                        }
                    }
                }
            }
        }
        return res;
    }
    //并查集
    public int findCircleNum3(int[][] isConnected){
        UnionFind uf = new UnionFind(isConnected.length);
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(isConnected[i][j]==1){
                    uf.union(i,j);
                }
            }
        }
        return uf.size;
    }

    static class UnionFind{
        private int size;
        private int[] parent;

        public UnionFind(int size) {
            this.size = size;
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int i){
            while(i!=parent[i]){
                i = parent[i];
            }
            return i;
        }

        public void union(int a,int b){
            int parentA = find(a);
            int parentB = find(b);
            if(parentA!=parentB){
                parent[parentA] = parentB;
                size--;
            }
        }
    }
}

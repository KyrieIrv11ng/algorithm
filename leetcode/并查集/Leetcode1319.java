package leetcode.并查集;

public class Leetcode1319 {
    public int makeConnected(int n, int[][] connections) {
        if(n-1>connections.length){
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        int count = 0;
        //合并
        for (int i = 0; i < connections.length; i++) {
            uf.union(connections[i][0],connections[i][1]);
        }
        //看有几个联通量
        for (int i = 0; i < uf.parent.length; i++) {
            if(uf.parent[i]==i){
                count++;
            }
        }
        return count-1;
    }

    class UnionFind{
        private int[] parent;
        public UnionFind(int size){
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX!=rootY){
                parent[rootX] = rootY;
            }
        }
    }
}

package leetcode;

public class Leetcode684 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length+1);
        for (int i = 1; i <= edges.length; i++) {
            int x = edges[i-1][0];
            int y = edges[i-1][1];
            if(!uf.isConnected(x,y)){
                uf.union(x,y);
            }else{
                return new int[]{x,y};
            }
        }
        return new int[0];
    }

    class UnionFind{
        private int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x){
            if(x!=parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x,int y){
            int xRoot = find(x);
            int yRoot = find(y);
            if(xRoot==yRoot){
                return;
            }
            parent[xRoot] = yRoot;
        }

        public boolean isConnected(int x,int y){
            int xRoot = find(x);
            int yRoot = find(y);
            if(xRoot==yRoot){
                return true;
            }else{
                return false;
            }
        }
    }
}

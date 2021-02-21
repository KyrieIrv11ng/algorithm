package leetcode.并查集;

public class Leetcode1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        //基本思路：··并查集 + 优先选择··
        //即分别对A 和 B进行并查集操作，并且优先选择··种类3··即··双向边··，再考虑单向边
        int result = 0;
        //a b 分别为Alice和Bob独享的并查集
        Union a = new Union(n);
        Union b = new Union(n);
        //优先考虑双向边
        for(int[] edge : edges) {
            if(edge[0] == 3) { //edge - 1是因为数组中的表示是以节点来表示的，需要减一
                boolean okA = a.union(edge[1] - 1, edge[2] - 1);
                boolean okB = b.union(edge[1] - 1, edge[2] - 1);
                //如果A B都已经相连过这条边，则删除
                if(okA && okB) {
                    result++;
                }
            }
        }
        //接下来考虑单向边
        for(int[] edge : edges) {
            if(edge[0] == 1) {
                //如果已经连接，则删除
                if(a.union(edge[1] - 1, edge[2] - 1)) {
                    result++;
                }
            }else if(edge[0] == 2) {
                if(b.union(edge[1] - 1, edge[2] - 1)) {
                    result++;
                }
            }
        }
        //如果最终可行，则返回删除的个数，如果不行则返回-1
        return a.check() && b.check() ? result : -1;
    }
}

//并查集模板，如果懂并查集就只看union和check就行
class Union {
    private int[] parent;
    private int n;
    Union(int n) {
        this.n = n;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    private int find(int id) {
        return parent[id] == id ? id : (parent[id] = find(parent[id]));
    }
    //如果已经连接则返回true
    public boolean union(int id1, int id2) {
        int root1 = find(id1);
        int root2 = find(id2);
        if(root1 == root2) {
            return true;
        }
        parent[root1] = root2;
        return false;
    }
    //如果可连通，那么只有一个根节点
    public boolean check() {
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(parent[i] == i) {
                count++;
            }
        }
        return count == 1;
    }
}

package leetcode.回溯DFS;

public class Leetcode60 {
    private int[] fac ;
    private boolean[] visited;
    private int n;
    private int k;
    private StringBuilder res = new StringBuilder();
    public String getPermutation(int n, int k) {
        if(n==0){
            return "";
        }
        this.n = n;
        this.k = k;
        this.visited = new boolean[n+1];    //设置boolean数组
        getFac(n);          //得到每个数的阶乘的数组
        dfs(0);
        return res.toString();
    }

    public void dfs(int index){
        if(index == n){
            return;         //注意，如果当前index等于n的时候，不做任何处理，直接返回，因为已经得到自己想要的数
        }
        int cur = fac[n-1-index];       //递归到每一层时计算一下当前的index能得到多少个排列组合
        for(int i = 1;i<n+1;i++){
            if(visited[i]){     //剪枝
                continue;
            }
            if(k>cur){      //剪枝，并且将k值进行更新
                k = k-cur;
                continue;
            }
            res.append(i);
            visited[i] = true;
            dfs(index+1);
            return;             //不用回溯，直接得到结果
        }
    }

    public void getFac(int n){
        fac = new int[n+1];
        fac[0] = 1;
        for (int i = 1; i < fac.length; i++) {
            fac[i] = fac[i-1]*i;
        }
    }
}

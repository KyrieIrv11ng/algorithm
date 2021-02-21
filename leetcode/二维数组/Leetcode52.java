package leetcode.二维数组;

public class Leetcode52 {
    int ans;
    boolean cols[],dia1[],dia2[];
    public int totalNQueens(int n) {
        this.ans = 0;
        this.cols = new boolean[n];
        this.dia1 = new boolean[2*n-1];
        this.dia2 = new boolean[2*n-1];
        putQueue(n,0);
        return ans;

    }

    public void putQueue(int n,int index){
        if(index == n){
            ans++;
        }
        for (int i = 0; i < n; i++) {
            if(!cols[i]&&!dia1[index+i]&&!dia2[index-i+n-1]){
                cols[i] = true;
                dia1[index+i] = true;
                dia2[index-i+n-1] = true;
                putQueue(n,index+1);
                cols[i] = false;
                dia1[index+i] = false;
                dia2[index-i+n-1] = false;
            }
        }
    }
}

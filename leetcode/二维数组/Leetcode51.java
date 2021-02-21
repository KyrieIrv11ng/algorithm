package leetcode.二维数组;

import java.util.ArrayList;
import java.util.List;

public class Leetcode51 {
    List<List<String>> res;
    boolean[] cols, dia1, dia2;
    List<String> l;
    int rows[];

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<List<String>>();
        }
        this.res = new ArrayList<>();
        this.l = new ArrayList<>();
        this.cols = new boolean[n];//竖排是否有重复的
        this.dia1 = new boolean[2 * n - 1];//主对角线是否有重复的 共有2n-1条
        this.dia2 = new boolean[2 * n - 1];//副对角线
        this.rows = new int[n];//索引代表第几行，元素代表第几列
        putQueen(n, 0);
        return res;
    }
    public void putQueen(int n, int index) {
        if (index == n) {
            res.add(new ArrayList<>(l));
        }
        for (int i = 0; i < n; i++) {
            if (!cols[i] && !dia1[index+i] && !dia2[index - i + n - 1]) {//如果符合要求，加入列表
                rows[index] = i;
                l.add(putString(n, rows, index));
                cols[i] = true;
                dia1[index+i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1);
                cols[i] = false;            //回溯
                dia1[index+i] = false;
                dia2[index - i + n - 1] = false;
                l.remove(index);
            }
        }
    }

    public String putString(int n, int[] rows, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == rows[index]) {
                sb.append("Q");
            } else sb.append(".");
        }
        return sb.toString();
    }
}

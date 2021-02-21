package leetcode.二维数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length==0||matrix[0].length==0){
            return new ArrayList<>();
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int x1 = 0;
        int y1 = 0;
        int x2 = rows-1;
        int y2 = cols-1;
        while(x1<=x2&&y1<=y2){
            addList(matrix,res,x1++,y1++,x2--,y2--);
        }
        return res;
    }

    public void addList(int[][] matrix,List<Integer> res,int x1,int y1,int x2,int y2){      //每次打印一圈
        if(x1 == x2){                   //如只有一行或者一列的情况
            while(y1<=y2){
                res.add(matrix[x1][y1++]);
            }
        }else if(y1 == y2){
            while(x1<=x2){
                res.add(matrix[x1++][y1]);
            }
        }else{
            int curx = x1;
            int cury = y1;
            while(cury<y2){
                res.add(matrix[x1][cury++]);
            }
            while(curx<x2){
                res.add(matrix[curx++][cury]);
            }
            while(cury>y1){
                res.add(matrix[curx][cury--]);
            }
            while(curx>x1){
                res.add(matrix[curx--][cury]);
            }
        }
    }

    //leetcode高赞题解
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0) {
            return res;
        }
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int col = left; col <= right; ++col) {
                res.add(matrix[up][col]);
            }
            if (++up > down) {
                break;
            }
            for (int row = up; row <= down; ++row) {
                res.add(matrix[row][right]);
            }
            if (--right < left) {
                break;
            }
            for (int col = right; col >= left; --col) {
                res.add(matrix[down][col]);
            }
            if (--down < up) {
                break;
            }
            for (int row = down; row >= up; --row) {
                res.add(matrix[row][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}

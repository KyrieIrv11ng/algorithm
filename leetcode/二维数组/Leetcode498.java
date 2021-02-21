package leetcode.二维数组;

import java.util.ArrayList;

public class Leetcode498 {
    //我的方法
    public int[] findDiagonalOrder(int[][] matrix) {
        int[] a = new int[0];
        if(matrix.length==0){
            return a;
        }
        ArrayList<Integer> al = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row1 = 0;
        int col1 = 0;
        int row2 = 0;
        int col2 = 0;
        boolean b = false;
        while(row1<rows){
            b = !b;
            addnums(al,row1, col1, row2, col2,b,matrix);
            row1 = col1==cols-1?row1+1:row1;
            col1 = row1==0?col1+1:cols-1;
            col2 = row2==rows-1?col2+1:col2;
            row2 = col2==0?row2+1:rows-1;
        }
        Integer[] array = al.toArray(new Integer[al.size()]);
        a = new int[al.size()];
        for (int i = 0;i<array.length;i++) {
            a[i] = array[i];
        }
        return a;

    }

    public static void addnums(ArrayList<Integer> al,int row1,int col1,int row2,int col2,boolean b,int[][] matrix){

        if(b){
            while(row1<=row2){
                al.add(matrix[row2][col2]) ;
                row2--;
                col2++;
            }

        }else{
            while(row1<=row2){
                al.add(matrix[row1][col1]);
                row1++;
                col1--;
            }

        }

    }
}

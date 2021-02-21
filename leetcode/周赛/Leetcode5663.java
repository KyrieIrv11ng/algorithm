package leetcode.周赛;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode5663 {
    public static int kthLargestValue(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int num = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        pq.offer(matrix[0][0]);
        for (int i = 1; i < rows; i++) {
            matrix[i][0] = matrix[i-1][0]^matrix[i][0];
            pq.offer(matrix[i][0]);
        }
        for (int i = 1; i < cols; i++) {
            matrix[0][i] = matrix[0][i-1]^matrix[0][i];
            pq.offer(matrix[0][i]);
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] = matrix[i][j]^matrix[i-1][j]^matrix[i][j-1]^matrix[i-1][j-1];
                pq.offer(matrix[i][j]);
            }
        }
        for (int i = 0; i < k; i++) {
            num = pq.poll();
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{5,2},{1,6}};
        System.out.println(kthLargestValue(m,3));
    }
}
